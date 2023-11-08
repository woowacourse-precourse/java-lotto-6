package lotto.view;


import java.util.List;

import static lotto.utils.Constants.*;

public class OutputView {

    public static void printTicketCount(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + PURCHASE_MESSAGE);
    }

    public static void printTicketList(List<Integer> ticket) {
        System.out.println(ticket);
    }

    public static void printWinningMessage() {
        System.out.println();
        System.out.println(WINNING_STATS_MESSAGE);
    }

    public static void printText(String text) {
        System.out.println(text);
    }

    public static void printEarningsRate(float earningsRate) {
        System.out.println(String.format(EARNINGS_RATE_MESSAGE, earningsRate));
    }
}
