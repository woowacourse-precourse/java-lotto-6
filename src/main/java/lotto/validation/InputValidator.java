package lotto.validation;

import lotto.constant.CommonSymbol;
import lotto.constant.ExceptionMessage;

public class InputValidator {

    public static void validateNumericInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            ExceptionMessage message = ExceptionMessage.NON_NUMERIC_INPUT_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }

    public static void validateDelimiterWithComma(String input) {
        CommonSymbol comma = CommonSymbol.COMMA;
        if (!input.contains(comma.getSymbol())) {
            ExceptionMessage message = ExceptionMessage.NO_COMMA_INPUT_EXCEPTION;
            throw new IllegalArgumentException(message.getMessage());
        }
    }
}
