package lotto.view;

import static lotto.constants.Message.ENTER_BONUS_NUMBER;
import static lotto.constants.Message.ENTER_PURCHASE_MONEY;
import static lotto.constants.Message.ENTER_WINNING_NUMBER;

public class InputView {
    private InputView() {
    }

    public static void printEnterAmount() {
        System.out.println(ENTER_PURCHASE_MONEY.getMessage());
    }

    public static void printEnterWinningNumber() {
        System.out.println(ENTER_WINNING_NUMBER.getMessage());
    }

    public static void printEnterBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER.getMessage());
    }
}
