package lotto.view;

import lotto.enums.OutputMsg;

public class OutputView {
    public void printPurchaseQuantity(int quantity) {
        System.out.printf(OutputMsg.PURCHASE_QUANTITY.getMsg(), quantity);
    }

    public void printResult() {
        System.out.println(OutputMsg.RESULT.getMsg());
        System.out.println(OutputMsg.RESULT_LINE.getMsg());
    }

    public void printProfit(double profit) {
        System.out.printf((OutputMsg.PROFIT.getMsg()) + "%n", profit);
    }

    public void printWinningDetails() {
    }
}
