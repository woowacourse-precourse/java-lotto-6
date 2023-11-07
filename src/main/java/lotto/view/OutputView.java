package lotto.view;

import lotto.enums.OutputMsg;

public class OutputView {
    public static void printPurchaseQuantity(int quantity) {
        System.out.printf(OutputMsg.PURCHASE_QUANTITY.getMsg(), quantity);
    }

    public static void printResult() {
        System.out.println(OutputMsg.RESULT.getMsg());
        System.out.println(OutputMsg.RESULT_LINE.getMsg());
    }

    public static void printProfit(double profit) {
        System.out.printf((OutputMsg.PROFIT.getMsg()) + "%n", profit);
    }

    public static void printWinningDetails() {
    }
}
