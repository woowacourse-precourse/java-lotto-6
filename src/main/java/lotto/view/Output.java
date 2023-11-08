package lotto.view;

import lotto.util.OutputMessage;

import java.util.List;

public class Output {

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.printf((OutputMessage.COUNT_PURCHASED_TICKETS.getMessage()) + "%n", lottoTickets.size());
        for (List<Integer> lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    public void printWinningStatistics(int[] lotteryResults, int matchFiveWithBonus) {
        System.out.println(OutputMessage.WINNING_STATISTICS.getMessage());
        System.out.println("---");

        System.out.printf((OutputMessage.COUNT_MATCH_3.getMessage()) + "%n", lotteryResults[3]);
        System.out.printf((OutputMessage.COUNT_MATCH_4.getMessage()) + "%n", lotteryResults[4]);
        System.out.printf((OutputMessage.COUNT_MATCH_5.getMessage()) + "%n", lotteryResults[5]);
        System.out.printf((OutputMessage.COUNT_MATCH_5_WITH_BONUS.getMessage()) + "%n", matchFiveWithBonus);
        System.out.printf((OutputMessage.COUNT_MATCH_6.getMessage()) + "%n", lotteryResults[6]);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf((OutputMessage.RATE_OF_RETURN.getMessage()) + "%n", rateOfReturn);
    }

}
