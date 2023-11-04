package lotto.view;
import static lotto.constant.ViewMessage.INPUT_PURCHASE_AMOUNT;
import static lotto.constant.ViewMessage.PURCHASE_LOTTO_COUNT;
import static lotto.constant.ViewMessage.INPUT_WINNING_NUMBERS;
import static lotto.constant.ViewMessage.INPUT_BONUS_NUMBER;

import lotto.constant.ViewMessage;

public class OutputView {
    public static void printInputPurchaseAmount() {
        printlnViewMessage(INPUT_PURCHASE_AMOUNT);
    }

    public static String printPurchaseLottoCount() {
        return PURCHASE_LOTTO_COUNT.toString();
    }

    public static void printInputWinnerNumbers() {
        printlnViewMessage(INPUT_WINNING_NUMBERS);
    }

    public static void printInputBonusNumber() {
        printlnViewMessage(INPUT_BONUS_NUMBER);
    }

    private static void printlnViewMessage(ViewMessage message) {
        System.out.println(message.toString());
    }
}
