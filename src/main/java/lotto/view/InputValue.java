package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputValue {
    public static String inputPurchase() {
        System.out.println(InputMessage.PURCHASE);
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(InputMessage.WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String inputBounusNumber() {
        System.out.println(InputMessage.BONUS_NUMBER);
        return Console.readLine();
    }
}
