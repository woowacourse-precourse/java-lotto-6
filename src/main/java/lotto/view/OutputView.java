package lotto.view;

public class OutputView {
    private static final String TICKET_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String SUCCESS_RESULT_MESSAGE = "당첨 통계\n---";

    public static void printTicketCnt(int cnt) {
        System.out.println(cnt + TICKET_COUNT_MESSAGE);
    }

    public static void printSuccessResult() {
        System.out.println(SUCCESS_RESULT_MESSAGE);
    }

    public static void printSuccessMessage(String message, int matchCnt) {
        System.out.println(message + matchCnt + "개");
    }

    public static void printRevenueRate(double earningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", earningRate) + "%입니다.");
    }

}
