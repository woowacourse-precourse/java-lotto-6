package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import lotto.model.LottoPlace;
import lotto.model.LottoStatus;
import lotto.model.MarginRate;
import lotto.model.Money;
import lotto.model.WinningResult;
import lotto.model.dto.LottoPaper;
import lotto.model.dto.LottoResult;

public class OuputView {
    private static final String COMMA = ",";
    private static final String WHITE_SPACE = " ";
    private static final String COUNT = "개";

    public void printErrorMessage(String errorMessage) {
        String formattedErrorMessage = formatErrorMessage(errorMessage);
        System.out.println(formattedErrorMessage);
    }

    public void printPublishedLottos(List<LottoPaper> lottoPapers) {
        printLottoCount(lottoPapers.size());
        printLottoNumbers(lottoPapers);

    }

    private void printLottoCount(int lottoSize) {
        System.out.println(lottoSize + COUNT + "를 구매했습니다.");
    }

    private void printLottoNumbers(List<LottoPaper> lottoPapers) {
        for (LottoPaper lottoPaper : lottoPapers) {
            System.out.println(foramtLottoNumbers(lottoPaper));
        }
        printEmptyLine();
    }

    private String foramtLottoNumbers(LottoPaper lottoPaper) {
        return "[" + concatNumbers(lottoPaper) + "]";
    }

    private String concatNumbers(LottoPaper lottoPaper) {
        return lottoPaper.getNumbers()
                .stream()
                .map(String::valueOf)
                .reduce((e1, e2) -> e1 + COMMA + WHITE_SPACE + e2)
                .orElseThrow(() -> new IllegalStateException("로또 용지가 없습니다."));
    }


    private String formatErrorMessage(String errorMessage) {
        return "[ERROR] " + errorMessage;
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        printWinningResult(lottoResult.getWinngResult());
        printMarginRate(lottoResult.getMarginRate());
    }

    private void printWinningResult(WinningResult winnigResult) {
        Arrays.stream(LottoPlace.values())
                .forEach(lottoPlace -> {
                    Integer count = winnigResult.getCount(lottoPlace);
                    printWinningResultDetail(lottoPlace, count);
                });
    }

    private void printWinningResultDetail(LottoPlace lottoPlace, Integer count) {
        LottoStatus lottoStatus = lottoPlace.getLottoStatus();
        Money prize = lottoPlace.getPrizeAmount();

        String detail = lottoStatus.getCorrectNumber()
                + "개 일치"
                + ifBounusRequired(lottoPlace.isBonusRequired())
                + " ("
                + formatDecimal(prize.getAmount())
                + "원)"
                + " - "
                + count
                + "개";

        System.out.println(detail);
    }

    private String ifBounusRequired(boolean isBonusRequired) {
        if (isBonusRequired) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private String formatDecimal(BigDecimal amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(amount);
    }

    private void printMarginRate(MarginRate marginRate) {
        System.out.println("총 수익률은 " + marginRate.getMarginRate() + "%입니다.");
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
