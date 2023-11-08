package lotto.view;

import static lotto.utils.GameMessage.*;
import static lotto.utils.GameMessage.WINNING;

public class Output {

    public void outputBoughtTicket(int games) {
        System.out.println(String.format(BOUGHT_TICKETS.getMessage(), games));
    }

    public void outputStatistic(int[] value) {
        System.out.println(WINNING_STATISTICS.getMessage());
        System.out.println("---");
        System.out.println(String.format(WINNING.getMessage(),3,5000,value[0]));
        System.out.println(String.format(WINNING.getMessage(),4,50000,value[1]));
        System.out.println(String.format(WINNING.getMessage(),5,1500000,value[3]));
        System.out.println(String.format(BONUS_WINNING.getMessage(),5,30000000,value[2]));
        System.out.println(String.format(WINNING.getMessage(),6,2000000000,value[4]));
    }

    public void outputProfitRate(double profitRate) {
        System.out.println(String.format(PROFIT_RATE.getMessage(), profitRate * 100));
    }
}
