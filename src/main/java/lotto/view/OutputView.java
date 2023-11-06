package lotto.view;

import lotto.enums.Output;

public class OutputView {
    public static void printPurchaseQuantity(int quantity) {
        System.out.printf(Output.PURCHASE_QUANTITY.getMessage(), quantity);
    }

    public static void printResult() {
        System.out.println(Output.RESULT.getMessage());
        System.out.println(Output.RESULT_LINE.getMessage());
    }

    public static void printProfit(double profit) {
        System.out.printf((Output.PROFIT.getMessage()) + "%n", profit);
    }

    public static void printWinningDetails() {
    }
}
