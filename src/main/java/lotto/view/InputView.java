package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.exception.NotNumberException;
import lotto.exception.NotNumbersFormatException;

public class InputView {
    public int inputNumber() {
        String input = Console.readLine();
        validateNumber(input);
        return Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        if (!input.matches("^\\d+$")) {
            throw new NotNumberException();
        }
    }

    public List<Integer> inputNumbers() {
        String input = Console.readLine();
        validateNumbers(input);
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateNumbers(String input) {
        if (!input.matches("^\\d+(,\\d+)*$")) {
            throw new NotNumbersFormatException();
        }
    }
}
