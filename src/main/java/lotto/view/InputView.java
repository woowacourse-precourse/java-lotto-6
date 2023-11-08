package lotto.view;

import static lotto.utils.ConstantString.DELIMITER;
import static lotto.utils.ErrorMessages.NOT_INTEGER_INPUT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static int getNumber() {
        String input = getTrimInputFromConsole();
        validateInteger(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> getNumbers() {
        String input = getTrimInputFromConsole();
        List<Integer> numbers = new ArrayList<>();
        for (String splittedInput : input.split(DELIMITER)) {
            String splittedTrimInput = splittedInput.trim();
            validateInteger(splittedTrimInput);
            numbers.add(Integer.parseInt(splittedTrimInput));
        }
        return numbers;
    }

    private static String getTrimInputFromConsole() {
        String input = Console.readLine();
        return input.trim();
    }

    private static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NOT_INTEGER_INPUT);
        }
    }
}
