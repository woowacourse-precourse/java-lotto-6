package lotto;

public class OutputView {
    public static void noticeTicketCount(Integer count) {
        printWhiteSpace();
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void noticeHeader() {
        printWhiteSpace();
        System.out.println("당첨 통계");
        printLine();
    }

    private static void printLine() {
        System.out.println("---");
    }

    public static void printResult(String result) {
        System.out.println(result);
    }

    private static void printWhiteSpace() {
        System.out.println();
    }
}
