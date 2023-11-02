package lotto.view;

public class PrintMessage {
    private static String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + TICKET_COUNT_MESSAGE);
    }
}
