package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.utils.ErrorMessage;
import lotto.utils.GameMessage;
import lotto.utils.Util;

public class InputView {
    public static int getMoneyInput() {
        System.out.println(GameMessage.ENTER_PURCHASE_AMOUNT_MESSAGE.getMessage());
        return getIntegerInput();
    }

    public static List<Integer> getWinningNumbersInput() {
        System.out.println(GameMessage.ENTER_WINNING_NUMBERS_MESSAGE.getMessage());
        return getIntegerListInput();
    }

    public static int getBonusNumberInput() {
        System.out.println(GameMessage.ENTER_BONUS_NUMBER_MESSAGE.getMessage());
        return getIntegerInput();
    }

    private static int getIntegerInput() {
        String input = Console.readLine();
        validateIntegerInput(input);
        return Integer.parseInt(input);
    }

    private static void validateIntegerInput(String input) {
        if (!Util.isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_NOT_INTEGER_ERROR.getMessage());
        }
    }

    private static List<Integer> getIntegerListInput() {
        String winningNumbersInput = Console.readLine();
        validateIntegerListInput(winningNumbersInput);
        return Util.convertStringToIntegerList(winningNumbersInput);
    }

    private static void validateIntegerListInput(String input) {
        List<String> parts = Arrays.asList(input.split(","));
        if (!parts.stream().allMatch(Util::isInteger)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_NOT_INTEGER_ERROR.getMessage());
        }
    }
}
