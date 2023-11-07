package lotto.view;

import lotto.service.LottoType;

import java.util.List;

public class OutputView {

    private final String BUY_TICKET_STATUS = "\n%d개를 구매했습니다.";
    private final String WINNING_STATISTICS = "당첨 통계";
    private final String LINE = "---";
    private final String MATCHED_COUNT = "%d개 일치";
    private final String WINNING_MONEY = " (%s원) - %d개";
    private final String BONUS = ", 보너스 볼 일치";
    private final String PROFIT_RATE = "총 수익률은 %.1f%%입니다.";

    public void printWinningStatisticsMessage() {
        System.out.println();
        System.out.println(WINNING_STATISTICS);
        System.out.println(LINE);
    }

    public void printLottoTicketMessage(int ticket) {
        System.out.println(String.format(BUY_TICKET_STATUS, ticket));
    }

    public void printMatchedCountMessage(LottoType count) {
        System.out.print(String.format(MATCHED_COUNT, count.getMatchCount()));
    }

    public void printWinningMoneyMessage(String winningMoney, int count) {
        if(winningMoney.equals(LottoType.MATCH_FIVE_BONUS.getPrize())) {
            printBonusMessage();
        }
        System.out.println(String.format(WINNING_MONEY, winningMoney, count));
    }

    private void printBonusMessage() {
        System.out.print(BONUS);
    }

    public void printProfitRateMessage(double rate) {
        System.out.println(String.format(PROFIT_RATE, rate));
    }

    public void printLottoNumber(List<Integer> lotto) {
        System.out.println(lotto);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
