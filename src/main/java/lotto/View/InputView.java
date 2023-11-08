package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.GameMessage;

public class InputView {
    public static String getAmountInput() {
        System.out.println(GameMessage.INPUT_AMOUNT.getMessage());

        String input = Console.readLine();

        return input;
    }

    public static String getWinningNumberInput() {
        System.out.println("\n" + GameMessage.INPUT_WINNING_NUMBER.getMessage());

        String input = Console.readLine();

        return input;
    }

    public static String getBonusNumberInput() {
        System.out.println("\n" + GameMessage.INPUT_BONUS_NUMBER.getMessage());

        String input = Console.readLine();

        return input;
    }
}
