package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.NotNumberException;

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
}
