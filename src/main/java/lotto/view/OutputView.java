package lotto.view;

public class OutputView {
    private static final String TICKET_COUNT_NOTICE = "개를 구매했습니다.";
    private static final String STATISTICS_CAPTION = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String DECIMAL_FORMAT = "%.1f%%";
    private static final String TOTAL_RATE_FORMAT = "총 수익률은 " + DECIMAL_FORMAT + "입니다.";

    public static void noticeTicketCount(Integer count) {
        printWhiteSpace();
        System.out.println(count + TICKET_COUNT_NOTICE);
    }

    public static void noticeHeader() {
        printWhiteSpace();
        System.out.println(STATISTICS_CAPTION);
        printLine();
    }

    private static void printLine() {
        System.out.println(SEPARATOR);
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    public static void printTotalRate(float totalRate) {
        System.out.printf(TOTAL_RATE_FORMAT, totalRate);
    }

    private static void printWhiteSpace() {
        System.out.println();
    }
}
