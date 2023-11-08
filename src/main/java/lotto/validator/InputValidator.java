package lotto.validator;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final int ZERO = 0;

    public static void isNotDigit(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MESSAGE + "숫자가 아닌 값을 입력했습니다.");
        }
    }

    public static void isNotPositiveNumber(String input) {
        if (Integer.parseInt(input) <= ZERO) {
            throw new NumberFormatException(ERROR_MESSAGE + "양수가 아닌 값을 입력했습니다.");
        }
    }

    public static void isNullOrIsEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "아무 것도 입력하지 않았습니다.");
        }
    }

    public static void includeSymbolExceptComma(String input) {
        if (!Pattern.matches("^[0-9,\\s]*$", input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "쉼표 외 특수 기호 혹은 문자가 포함되어 있습니다.");
        }
    }

    public static void isNotDigits(List<String> inputs) {
        for (String number : inputs) {
            try {
                Integer.parseInt(number);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(ERROR_MESSAGE + "숫자가 아닌 값이 포함되어 있습니다.");
            }
        }
    }

    public static void isNotOneNumber(String input) {
        if (input.contains(",")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "숫자 1개만 입력하세요.");
        }
    }
}
