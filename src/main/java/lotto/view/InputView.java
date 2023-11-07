package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.EmptyInputException;

public class InputView {

    public String readInput() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private void validateInput(final String input) {
        if (isInvalidInput(input)) {
            throw new EmptyInputException();
        }
    }

    private boolean isInvalidInput(final String input) {
        return input == null || input.isBlank();
    }
}
