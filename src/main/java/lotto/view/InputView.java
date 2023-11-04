package lotto.view;

import static lotto.constant.message.InputMessage.PURCHASE_PRICE;
import static lotto.constant.message.InputMessage.WINNING_NUMBER;

import lotto.util.Util;

public class InputView {
    public static String requestPurchasePrice() {
        System.out.println(PURCHASE_PRICE);
        printLineChanging();

        return Util.readInput();
    }

    public static String requestWinningNumber() {
        System.out.println(WINNING_NUMBER);
        printLineChanging();

        return Util.readInput();
    }

    public static void printLineChanging() {
        System.out.println();
    }

}
