package lotto.view;

public class OutputView {
    private static final String TICKET_COUNT = "개를 구매했습니다.";
    public static void printLottoCount(int ticketCount) {
        System.out.println(ticketCount + TICKET_COUNT);
    }
}
