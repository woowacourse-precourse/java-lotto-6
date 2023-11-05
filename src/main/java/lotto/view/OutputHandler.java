package lotto.view;

import lotto.constant.SystemMessage;

public class OutputHandler {

    public static void requirePaymentPrice() {
        System.out.println(SystemMessage.REQUIRE_PAYMENT_PRICE);
    }
    public static void sayTicketCount(int ticketCount) {
        System.out.println(ticketCount + SystemMessage.SAY_TICKET_COUNT_FORMAT);
    }
    public static void printEmptyLine() {
        System.out.println();
    }

}
