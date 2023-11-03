package lotto.view;

import static lotto.constant.Message.BOUGHT_QUANTITY_MESSAGE;
import static lotto.constant.Message.BUYING_PRICE_MESSAGE;
import static lotto.constant.Message.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.constant.Message.INPUT_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;

public class View {

    public static void printStartMessage() {
        System.out.println(BUYING_PRICE_MESSAGE.getMessage());
    }

    public static String input() {
        String input =  Console.readLine();
        System.out.println();
        return input;
    }

    public static void printPurchaseMessage(int quantity) {
        System.out.println(quantity + BOUGHT_QUANTITY_MESSAGE.getMessage());
    }

    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto);
        }
        System.out.println();
    }

    public static String printInputNumberMessage() {
        System.out.println(INPUT_NUMBER_MESSAGE.getMessage());
        return input();
    }

    public static String printInputBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.getMessage());
        return input();
    }

}
