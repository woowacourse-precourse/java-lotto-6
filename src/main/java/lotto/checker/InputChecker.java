package lotto.checker;

import lotto.constant.ExceptionMessage;
import lotto.view.OutputHandler;

public class InputChecker {

    public static void nonEmpty(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            OutputHandler.requireNonemptyInput();
            throw new IllegalArgumentException(ExceptionMessage.REQUIRE_NONEMPTY_INPUT.getMessage());
        }
    }
}
