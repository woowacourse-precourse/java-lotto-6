package lotto.view;

public class OutputView {
    private static final String OUTPUT_PURCHASE_AMOUNT = "개를 구매했습니다.";

    public static void printPurchaseCount(int ticketCount) {
        System.out.println(ticketCount + OUTPUT_PURCHASE_AMOUNT);
    }
}
