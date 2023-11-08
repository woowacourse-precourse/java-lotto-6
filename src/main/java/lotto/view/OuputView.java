package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import lotto.model.dto.LottoPaper;
import lotto.model.dto.LottoResult;
import lotto.model.dto.MarginRateDto;
import lotto.model.dto.WinningResultDto;

public class OuputView {
    private static final String COMMA = ",";
    private static final String WHITE_SPACE = " ";
    private static final String COUNT = "개";

    public void printErrorMessage(String errorMessage) {
        String formattedErrorMessage = formatErrorMessage(errorMessage);
        System.out.println(formattedErrorMessage);
        printEmptyLine();
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
            System.out.println(formatLottoNumbers(lottoPaper));
        }
        printEmptyLine();
    }

    private String formatLottoNumbers(LottoPaper lottoPaper) {
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
        printWinningResult(lottoResult.getWinningResultDtos());
        printMarginRate(lottoResult.getMarginRateDto());
    }

    private void printWinningResult(List<WinningResultDto> winningResultDto) {
        winningResultDto.forEach(this::printWinningResultDetail);
    }

    private void printWinningResultDetail(WinningResultDto winningResultDto) {
        int correctNumberCount = winningResultDto.getCountCorrect();
        boolean isBonusNumberCorrect = winningResultDto.isBonusBallCorrect();
        BigDecimal prizeAmount = winningResultDto.getAmount();
        int countLottos = winningResultDto.getCountLottos();

        String winningResultDetail = String.format("%d개 일치%s (%s원) - %d개,"
                , correctNumberCount
                , ifBonusCorrect(isBonusNumberCorrect)
                , formatDecimal(prizeAmount)
                , countLottos);

        System.out.println(winningResultDetail);
    }

    private String ifBonusCorrect(boolean isBonusNumberCorrect) {
        if (isBonusNumberCorrect) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

    private String formatDecimal(BigDecimal amount) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(amount);
    }

    private void printMarginRate(MarginRateDto marginRateDto) {
        System.out.println("총 수익률은 "
                + formatDecimal(marginRateDto.getWholePart())
                + "."
                + marginRateDto.getFractionalPart().toPlainString()
                + "%입니다.");
    }

    private void printEmptyLine() {
        System.out.println();
    }
}
