package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.configuration.InputMessage;

public class InputView {

    public static String input() {
        return Console.readLine();
    }

    public static void inputViewPurchaseAmount() {
        System.out.println(InputMessage.INPUT_PURCHASE_AMOUNT.inputMessage());
    }

    public static void inputViewWinningNumber() {
        System.out.println();
        System.out.println(InputMessage.INPUT_WINNING_NUMBERS.inputMessage());
    }

    public static void inputViewBonusNumber() {
        System.out.println();
        System.out.println(InputMessage.INPUT_BONUS_NUMBER.inputMessage());
    }
}
