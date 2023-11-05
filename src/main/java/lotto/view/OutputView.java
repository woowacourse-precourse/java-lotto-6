package lotto.view;

public class OutputView {
    static final String PURCHASE_OUTPUT_MESSAGE = "개를 구매했습니다.";

    public static void printNumberOfLottoPurchase(int count) {
        System.out.println("\n" + count + PURCHASE_OUTPUT_MESSAGE);
    }
}
