package view;

import static constant.ConstantMessage.FIFTH_MATCH;
import static constant.ConstantMessage.FIRST_MATCH;
import static constant.ConstantMessage.FOURTH_MATCH;
import static constant.ConstantMessage.PURCHASED;
import static constant.ConstantMessage.SECOND_MATCH;
import static constant.ConstantMessage.SEPARATOR;
import static constant.ConstantMessage.STATISTICS_START;
import static constant.ConstantMessage.THIRD_MATCH;
import static constant.ConstantMessage.TOTAL_RATE_OF_RETURN;
import static constant.ConstantNumber.LOTTO_PRICE;

import constant.Rank;
import java.util.HashMap;

public class OutputView {
    private OutputView() {
    }

    public static long LottoTicketCount(long money) {
        long ticketCount = money / LOTTO_PRICE.getNumber();
        System.out.printf((PURCHASED.getMessage()) + "%n", ticketCount);
        return ticketCount;
    }

    public static void resultStart() {
        System.out.println(STATISTICS_START.getMessage());
        System.out.println(SEPARATOR.getMessage());
    }

    public static void printStatistics(HashMap<Rank, Integer> rankCountsMap) {
        System.out.printf((FIFTH_MATCH.getMessage()) + "%n", rankCountsMap.get(Rank.FIFTH));
        System.out.printf((FOURTH_MATCH.getMessage()) + "%n", rankCountsMap.get(Rank.FOURTH));
        System.out.printf((THIRD_MATCH.getMessage()) + "%n", rankCountsMap.get(Rank.THIRD));
        System.out.printf((SECOND_MATCH.getMessage()) + "%n", rankCountsMap.get(Rank.SECOND));
        System.out.printf((FIRST_MATCH.getMessage()) + "%n", rankCountsMap.get(Rank.FIRST));
    }

    public static void printRateOfReturn(double rateOfReturn) {
        System.out.printf((TOTAL_RATE_OF_RETURN.getMessage()) + "%n", rateOfReturn);
    }

    public static void errorMessage(IllegalArgumentException error) {
        System.out.println(error.getMessage());
    }
}
