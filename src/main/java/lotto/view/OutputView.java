package lotto.view;

import lotto.constants.MsgConstants;

public class OutputView {

    public static void printErrorMessage(String err) {
        System.out.println(err);
    }


    public static void printEnterPurchaseAmount() {
        System.out.println(MsgConstants.PLEASE_ENTER_PURCHASE_AMOUNT.getData());
    }

    public static void printPurchasedLottoNumber(String msg) {
        System.out.println(msg);
    }
    public static void printEnterWinningNumber() {
        System.out.println(MsgConstants.PLEASE_ENTER_WINNING_NUMBER.getData());
    }

}
