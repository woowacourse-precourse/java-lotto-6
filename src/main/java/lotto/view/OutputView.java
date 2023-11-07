package lotto.view;

import lotto.constants.MsgConstants;

import static lotto.constants.MsgConstants.PURCHASED_SOME_PIECES;

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
    public static void printEnterBonusNumber() {
        System.out.println(MsgConstants.PLEASE_ENTER_BONUS_NUMBER.getData());
    }
    public static void printPurchasedQuantity(int quantity) {
        System.out.printf((PURCHASED_SOME_PIECES.getData()) + "%n",quantity);
    }

}
