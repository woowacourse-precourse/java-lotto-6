package lotto.validator;

import lotto.message.ErrorMessageFormatter;

public class TypeMismatchValidator {

    public static String INPUT_NOT_INTEGER_MESSAGE = "정수만 입력될 수 있습니다.";

    public static void validateInputInteger(
        String input,
        String message
    ) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessageFormatter.errorMessage(message));
        }
    }
}
