package lotto.view.validator;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String INVALID_INPUT_EXCEPTION_MESSAGE = "입력은 공백일 수 없습니다.";
    private static final String NOT_DIGIT_EXCEPTION_MESSAGE = "구입 금액에 대한 입력은 숫자만 가능합니다.";

    private static final Pattern ONLY_DIGIT = Pattern.compile("-?[0-9]+");

    protected static void validateInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static void validatePurchaseAmount(String input) {
        validateInput(input);

        if (isNotDigit(input)) {
            throw new IllegalArgumentException(NOT_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNotDigit(String input) {
        return !ONLY_DIGIT.matcher(input)
                .matches();
    }
}
