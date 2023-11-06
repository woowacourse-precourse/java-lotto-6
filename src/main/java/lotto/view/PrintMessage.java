package lotto.view;

public class PrintMessage {
    private static String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static String WINNING_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + TICKET_COUNT_MESSAGE);
    }

    public static void printWinnigLotto() {
        System.out.println(WINNING_LOTTO_INPUT_MESSAGE);
    }
}
