package lotto;

public class OutputView {
    public static void noticeTicketCount(Integer count) {
        printWhiteSpace();
        System.out.println(count + "개를 구매했습니다.");
    }

    private static void printWhiteSpace() {
        System.out.println();
    }
}
