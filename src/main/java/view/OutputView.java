package view;

import message.InputMessage;

public class OutputView {

    public static void printPurchaseAmountInputMessage() {
        System.out.println(InputMessage.PURCHASE_AMOUNT_MESSAGE.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
