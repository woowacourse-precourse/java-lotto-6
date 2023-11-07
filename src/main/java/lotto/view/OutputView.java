package lotto.view;

import lotto.constants.MsgConstants;

public class OutputView {

    public static void printErrorMessage(String err) {
        System.out.println(err);
    }


    public static void printEnterPurchaseAmount() {
        System.out.println(MsgConstants.PLEASE_ENTER_PURCHASE_AMOUNT.getData());
    }
}
