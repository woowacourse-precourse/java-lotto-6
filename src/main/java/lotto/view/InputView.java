package lotto.view;

import static lotto.utils.ErrorMessages.NOT_INTEGER_INPUT;
import static lotto.utils.ConstantString.DELIMITER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public int getNumber() {
        String input = getTrimInputFromConsole();
        validateInteger(input);
        return Integer.parseInt(input);
    }

    public List<Integer> getNumbers() {
        String input = getTrimInputFromConsole();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String splittedInput : input.split(DELIMITER)) {
            validateInteger(splittedInput);
            winningNumbers.add(Integer.parseInt(splittedInput));
        }
        return winningNumbers;
    }

    private String getTrimInputFromConsole() {
        String input = Console.readLine();
        return input.trim();
    }

    private void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NOT_INTEGER_INPUT);
        }
    }
}
