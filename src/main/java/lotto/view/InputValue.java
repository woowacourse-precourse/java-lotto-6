package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputValue {
    public static String inputPurchase() {
        System.out.println(InputMessage.PURCHASE.getMessage());
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(InputMessage.WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}
