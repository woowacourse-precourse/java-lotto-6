package lotto.view;

import static lotto.constant.message.InputMessage.DELIMITER;
import static lotto.constant.message.InputMessage.WINNING_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.util.Util;

public class InputView {

//    public static int requestPurchasePrice() {
//        System.out.println(PURCHASE_PRICE);
//
//        int money = ZERO.getNumber();
//        try {
//            Integer.parseInt(readNumber());
//        } catch (NumberFormatException e) {
//            System.out.println(NON_INTEGER_MONEY);
//            requestPurchasePrice();
//        }
//
//        return money;
//    }

    public static String requestWinningNumber() {
        System.out.println(WINNING_NUMBER);
        return Util.readInput();
    }

    public static void printLineChanging() {
        System.out.println();
    }

}
