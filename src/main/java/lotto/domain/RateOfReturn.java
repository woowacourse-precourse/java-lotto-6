package lotto.domain;

import java.util.List;

import static lotto.output.Constants.RateOfReturnConstants.PERCENT_NUMBER;
import static lotto.output.Constants.RateOfReturnConstants.TOTAL_RATE_OF_RETURN_IS;

public class RateOfReturn {
    private static final List<Integer> RANK_VALUE = List.of(5000, 5000, 1500000, 30000000, 2000000000);

    public static double calculateRateOfReturn(int ticket,List<Integer> winnings) {
        int investment = ticketToMoney(ticket);
        int profit = addTotalResult(winnings);
        return rateOfReturn(investment, profit);
    }

    private static int ticketToMoney(int ticket) {
        int money = ticket * 1000;
        return money;
    }

    private static int addTotalResult(List<Integer> winnings) {
        int total = 0;
        for (int i = 0; i < winnings.size(); i++) {
            int ticket = winnings.get(i);
            int value = RANK_VALUE.get(i);
            total += ticket * value;

        }
        return total;
    }

    public static double rateOfReturn(int investment, int profit) {
        return (double) profit / investment * 100.0;
    }

    public static void rateOfReturnOutput(double result) {
        System.out.println(TOTAL_RATE_OF_RETURN_IS + result + PERCENT_NUMBER);
    }
}
