package lotto.view;

import lotto.enums.OutputMsg;

public class OutputView {
    public static void printPurchaseQuantity(int quantity) {
        System.out.printf(OutputMsg.PURCHASE_QUANTITY.getMessage(), quantity);
    }

    public static void printResult() {
        System.out.println(OutputMsg.RESULT.getMessage());
        System.out.println(OutputMsg.RESULT_LINE.getMessage());
    }

    public static void printProfit(double profit) {
        System.out.printf((OutputMsg.PROFIT.getMessage()) + "%n", profit);
    }

    public static void printWinningDetails() {
    }
}
