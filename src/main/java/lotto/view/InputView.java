package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.messages.Error;

public class InputView {
    public String read() {
        String input = Console.readLine();
        validateInputFormat(input);
        return input;
    }

    private void validateInputFormat(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(Error.INPUT_FORMAT_NULL_OR_EMPTY.getMessage());
        }
    }
}