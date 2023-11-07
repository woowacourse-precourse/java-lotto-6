package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.utils.ErrorMessage;
import lotto.utils.GameMessage;
import lotto.utils.Util;

public class InputView {
    public static int getMoneyInput() {
        OutputView.printMessage(GameMessage.ENTER_PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();
        return convertToInt(input);
    }

    public static List<Integer> getWinningNumbersInput() {
        System.out.println();
        OutputView.printMessage(GameMessage.ENTER_WINNING_NUMBERS_MESSAGE);
        String winningNumbersInput = Console.readLine();
        return convertToIntegerList(winningNumbersInput);
    }

    public static int getBonusNumberInput() {
        System.out.println();
        OutputView.printMessage(GameMessage.ENTER_BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        return convertToInt(input);
    }

    private static int convertToInt(String input) {
        validateIntegerInput(input);
        return Integer.parseInt(input);
    }

    private static void validateIntegerInput(String input) {
        if (!Util.isInteger(input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MONEY_NOT_INTEGER_ERROR.getMessage());
        }
    }

    private static List<Integer> convertToIntegerList(String winningNumbersInput) {
        validateIntegerList(winningNumbersInput);
        return Util.convertStringToIntegerList(winningNumbersInput);
    }

    private static void validateIntegerList(String input) {
        List<String> parts = Arrays.asList(input.split(","));
        if (!parts.stream().allMatch(Util::isInteger)) {
            throw new IllegalArgumentException(ErrorMessage.WINNING_NUMBER_NOT_INTEGER_ERROR.getMessage());
        }
    }
}
