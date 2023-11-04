package lotto.validator.input;

import java.util.List;

public class InputCommonValidator {

    private static final String INVALID_NUMBER_FORMAT = "[ERROR] 숫자만 입력해야 합니다.";

    private InputCommonValidator() {
    }

    public static void validateMultiple(final List<String> inputs) {
        inputs.forEach(InputCommonValidator::validateNumber);
    }

    public static void validateSingle(final String input) {
        validateNumber(input);
    }

    private static void validateNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
        }
    }
}
