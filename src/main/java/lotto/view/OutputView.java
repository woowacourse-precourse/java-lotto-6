package lotto.view;


import lotto.view.constants.RequestMessage;
import lotto.view.constants.ResponseMessage;

public class OutputView {
    private OutputView() {
    }

    public static void printRequestPurchaseAmount() {
        System.out.println(RequestMessage.PURCHASE_AMOUNT.getMessage());
    }

    public static void printResponsePurchaseAmount(final int amount) {
        String formattedMessage = String.format(ResponseMessage.PURCHASE_AMOUNT.getMessage(), amount);
        System.out.println(formattedMessage);
    }
}
