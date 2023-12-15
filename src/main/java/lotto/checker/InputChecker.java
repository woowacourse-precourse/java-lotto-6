package lotto.checker;

import static lotto.constant.ExceptionMessage.REQUIRE_NONEMPTY_INPUT;

import lotto.view.OutputHandler;

public class InputChecker {

    public static void nonEmpty(String input) throws IllegalArgumentException {
        if (input.isEmpty()) {
            OutputHandler.requireNonemptyInput();
            throw new IllegalArgumentException(REQUIRE_NONEMPTY_INPUT.getMessage());
        }
    }

    public static void nonNull(String input) throws IllegalArgumentException {
        if (input == null) {
            OutputHandler.requireNonemptyInput();
            throw new IllegalArgumentException(REQUIRE_NONEMPTY_INPUT.getMessage());
        }
    }
}
