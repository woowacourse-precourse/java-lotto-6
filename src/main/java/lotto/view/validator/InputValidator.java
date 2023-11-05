package lotto.view.validator;

import org.junit.platform.commons.util.StringUtils;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String INVALID_INPUT_EXCEPTION_MESSAGE = "입력은 공백일 수 없습니다.";
    private static final String NOT_DIGIT_EXCEPTION_MESSAGE = "입력은 숫자만 가능합니다.";
    private static final String INVALID_FORMAT_EXCEPTION_MESSAGE = "당첨 번호에 대한 입력 형식이 올바르지 않습니다.";

    private static final String ABOUT_PURCHASE_AMOUNT_MESSAGE = "구입 금액에 대한 ";
    private static final String ABOUT_BONUS_NUMBER_MESSAGE = "보너스 번호에 대한 ";

    private static final Pattern ONLY_DIGIT_PATTERN = Pattern.compile("-?[0-9]+");
    private static final Pattern VALID_FORMAT_PATTERN = Pattern.compile("-?[0-9]+(,-?[0-9]+)*");

    protected static void validateInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INVALID_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static void validatePurchaseAmount(String input) {
        validateInput(input);

        if (isNotDigit(input)) {
            throw new IllegalArgumentException(ABOUT_PURCHASE_AMOUNT_MESSAGE + NOT_DIGIT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isNotDigit(String input) {
        return !ONLY_DIGIT_PATTERN.matcher(input)
                .matches();
    }

    public static void validateWinningNumbers(String input) {
        validateInput(input);

        if (isInvalidFormat(input)) {
            throw new IllegalArgumentException(INVALID_FORMAT_EXCEPTION_MESSAGE);
        }
    }

    private static boolean isInvalidFormat(String input) {
        return !VALID_FORMAT_PATTERN.matcher(input)
                .matches();
    }

    public static void validateBonusNumber(String input) {
        validateInput(input);

        if (isNotDigit(input)) {
            throw new IllegalArgumentException(ABOUT_BONUS_NUMBER_MESSAGE + NOT_DIGIT_EXCEPTION_MESSAGE);
        }
    }
}
