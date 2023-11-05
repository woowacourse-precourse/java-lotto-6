package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.PrintMessages;

public class InputHandler {
    public static String purchasePrice() {
        System.out.println(PrintMessages.INPUT_PRICE);
        return Console.readLine();
    }

    public static String winningNumber() {
        System.out.println(PrintMessages.INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String bonusNumber() {
        System.out.println(PrintMessages.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }
}
