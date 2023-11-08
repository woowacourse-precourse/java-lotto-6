package lotto.view.input;

import java.util.regex.Pattern;

public class IntegerInput {
    private static final Pattern INTEGER_PATTERN = Pattern.compile("[+-]?\\d+");
    private static final String INPUT_TYPE_ERROR_MESSAGE = "숫자만 입력 가능합니다.";

    private final int value;

    public IntegerInput(String input) {
        validateInteger(input);

        this.value = Integer.parseInt(input);
    }

    private void validateInteger(String input) {
        if (!INTEGER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(INPUT_TYPE_ERROR_MESSAGE);
        }
    }

    public int value() {
        return value;
    }
}
