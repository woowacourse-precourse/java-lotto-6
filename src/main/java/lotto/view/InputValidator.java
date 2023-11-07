package lotto.view;

import java.util.Arrays;

public class InputValidator {

    private static final String EMPTY = "값을 입력해주세요.";
    private static final String NO_INTEGER = "숫자만 입력해주세요.";
    private static final String NO_INTEGER_ARRAY = "숫자와 쉼표(,)만 입력해주세요.";

    public void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY);
        }
    }

    public void validateInteger(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NO_INTEGER);
        }
    }

    public void validateIntegerArray(final String[] input) {
        try {
            Arrays.stream(input).forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NO_INTEGER_ARRAY);
        }
    }
}
