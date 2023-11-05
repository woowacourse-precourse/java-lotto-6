package lotto.view;

import lotto.utils.GameMessage;

public class OutputView {
    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printTicketCount(int ticketCount) {
        System.out.printf(GameMessage.PURCHASED_TICKET_COUNT.getMessage(), ticketCount);
        System.out.println();
    }
}
