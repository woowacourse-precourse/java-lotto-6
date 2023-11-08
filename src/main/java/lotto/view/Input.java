package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String inputBuyPrice() {
        System.out.println(EnumOutput.REQUEST_BUY_MONEY.getMessage());
        return Console.readLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(EnumOutput.REQUEST_WINNING_NUMBERS.getMessage());
        return Console.readLine();
    }

    public static String inputBonusNumber() {
        System.out.println(EnumOutput.REQUEST_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}