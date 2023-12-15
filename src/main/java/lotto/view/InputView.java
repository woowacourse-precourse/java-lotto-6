package lotto.view;

import static lotto.view.ErrorMessage.ERROR;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static int inputMoney() {
        String input = Console.readLine();
        return validateMoneyInput(input);
    }

    private static int validateMoneyInput(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    public static List<Integer> inputWinningNumbers() {
        String[] input = Console.readLine().split(",");
        return validateWinningNumbers(input);
    }

    private static List<Integer> validateWinningNumbers(String[] input) {
        try {
            return Arrays.stream(input).map(number -> Integer.parseInt(number.trim())).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR);
        }
    }

    public static int inputBonusNumber() {
        String input = Console.readLine();
        return validateBonusNumberInput(input);
    }

    private static int validateBonusNumberInput(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR);
        }
    }
}
