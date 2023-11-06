package lotto.view;


import lotto.view.constants.RequestMessage;

public class OutputView {
    private OutputView() {
    }

    public static void printRequestPurchaseAmount() {
        System.out.println(RequestMessage.PURCHASE_AMOUNT);
    }
}
