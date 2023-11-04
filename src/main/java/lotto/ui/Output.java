package lotto.ui;

public class Output {
    private static final String PURCHASE_COUNT_COMMAND = "개를 구매했습니다.";
    private static final String NEXT_LINE = "\n";

    public static void printPurchaseCount(int count) {
        System.out.println(NEXT_LINE + count + PURCHASE_COUNT_COMMAND);
    }
}
