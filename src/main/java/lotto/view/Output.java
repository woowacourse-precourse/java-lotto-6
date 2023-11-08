package lotto.view;

import lotto.util.OutputMessage;

import java.util.List;

public class Output {

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println(String.format(OutputMessage.COUNT_PURCHASED_TICKETS.getMessage(), lottoTickets.size()));
        for (List<Integer> lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    public void printWinningStatistics(int[] lotteryResults, int matchFiveWithBonus) {
        System.out.println(OutputMessage.WINNING_STATISTICS.getMessage());
        System.out.println("---");

        System.out.println(String.format(OutputMessage.COUNT_MATCH_3.getMessage(), lotteryResults[3]));
        System.out.println(String.format(OutputMessage.COUNT_MATCH_4.getMessage(), lotteryResults[4]));
        System.out.println(String.format(OutputMessage.COUNT_MATCH_5.getMessage(), lotteryResults[5]));
        System.out.println(String.format(OutputMessage.COUNT_MATCH_5_WITH_BONUS.getMessage(), matchFiveWithBonus));
        System.out.println(String.format(OutputMessage.COUNT_MATCH_6.getMessage(), lotteryResults[6]));
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(OutputMessage.RATE_OF_RETURN.getMessage(), rateOfReturn));
    }

}
