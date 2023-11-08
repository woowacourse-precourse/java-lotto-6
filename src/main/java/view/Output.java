package view;

public class Output {
    private static final String TAB = "";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String SEPERATE_LINE = "---";

    public static void printCount(int purchase) {
        System.out.println(TAB);
        System.out.println(purchase + PURCHASE_MESSAGE);
    }

    public static void printResult() {
        System.out.println(TAB);
        System.out.println(RESULT_MESSAGE);
        System.out.println(SEPERATE_LINE);
    }
}
