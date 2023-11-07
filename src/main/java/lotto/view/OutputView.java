package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.domain.prize.Prize;
import lotto.domain.prize.WinningDetails;

public class OutputView {
    private static final String LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNIG_STATISTICS_MESSAGE = "당첨 통계";
    private static final String BOUNDARY = "---";
    private static final String WINNIG_DETAILS_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String SECOND_PLACE_WINNING_DETAIL_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void showIssuedLottoResult(List<String> issuedLottos) {
        Collections.sort(issuedLottos);
        showLottoAmount(issuedLottos.size());
        showLottoNumbers(issuedLottos);
    }

    public void showLottoAmount(int lottoAmount) {
        System.out.println(String.format(LOTTO_AMOUNT_MESSAGE, lottoAmount));
    }

    public void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void showLottoNumbers(List<String> lottoNumbers) {
        lottoNumbers.stream().forEach(System.out::println);
    }

    public void showLottoResult(WinningDetails winningDetails) {
        System.out.println(WINNIG_STATISTICS_MESSAGE);
        System.out.println(BOUNDARY);
        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.NO_PRIZE)
                .map(prize -> formatString(prize, winningDetails))
                .forEach(System.out::println);
    }

    public void showProfitRate(double profitRate) {
        System.out.println(String.format(PROFIT_RATE_MESSAGE, profitRate));
    }

    private String formatString(Prize prize, WinningDetails winningDetails) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        String formattedPrizeMoney = formatter.format(prize.getPrizeMoney());
        String winningDetailMessage = selectWinningMessage(prize);

        return String.format(winningDetailMessage, prize.getMatchingNumberCount(), formattedPrizeMoney,
                winningDetails.getPrizeAmount(prize));
    }

    private String selectWinningMessage(Prize prize) {
        if (prize == Prize.SECOND_PLACE) {
            return SECOND_PLACE_WINNING_DETAIL_MESSAGE;
        }

        return WINNIG_DETAILS_MESSAGE;
    }

    public void nextLine() {
        System.out.println();
    }
}
