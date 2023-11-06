package lotto.domain.util.validator;

import lotto.domain.config.ValidatorConfig;

public class InputValidator {
    private static final String ERROR_MESSAGE = ValidatorConfig.ERROR_MESSAGE.getMessage();
    private static final String NOT_NUMBER_ERROR_MESSAGE = "수를 입력해야 합니다.";
    private static final String NOT_NUMBER_OR_NOT_COMMA_ERROR_MESSAGE = "당첨 번호를 쉼표로 구분하여 입력해야 합니다.";
    private static final char COMMA = ',';

    private InputValidator() {
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    public static void validateNumberOrComma(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c) && c != COMMA) {
                throw new IllegalArgumentException(ERROR_MESSAGE + NOT_NUMBER_OR_NOT_COMMA_ERROR_MESSAGE);
            }
        }
    }
}
