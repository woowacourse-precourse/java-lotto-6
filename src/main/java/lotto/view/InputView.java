package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.Input;

public class InputView {
    public static String purchaseAmount() {
        System.out.println(Input.PURCHASE_AMOUNT.getMessage());
        return Console.readLine();
    }

    public static String winningNumber() {
        System.out.println(Input.WINNING_NUMBER.getMessage());
        return Console.readLine();
    }

    public static String bonusNumber() {
        System.out.println(Input.BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
