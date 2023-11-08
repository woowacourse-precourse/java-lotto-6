package lotto.view;

import java.util.List;

public class OutputView {
    private static final String BUY_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String LINE_SEPARATOR = "---";

    public void printUserLottos(List<String> lottoMessages, long buyAmount) {
        System.out.println();
        System.out.println(String.format(BUY_AMOUNT_MESSAGE, buyAmount));
        lottoMessages.forEach(this::printLotto);
        System.out.println();
    }

    private void printLotto(String lottoMessage) {
        System.out.println(lottoMessage);
    }

    public void printWinningResult(List<String> ranksStatistics, double totalProfitRate) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(LINE_SEPARATOR);
        ranksStatistics.forEach(System.out::println);

        System.out.println(String.format(TOTAL_PROFIT_RATE_MESSAGE, totalProfitRate));

    }
}
