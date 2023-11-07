package lotto.validator.input;

import java.util.List;
import lotto.validator.input.exception.InputExceptionMessage;

public class InputCommonValidator {

    private InputCommonValidator() {
    }

    public static void validateNumbers(final List<String> inputs) {
        inputs.forEach(InputCommonValidator::validateNumber);
    }

    public static void validateNumber(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw InputExceptionMessage.INVALID_NUMBER_FORMAT.create();
        }
    }
}
