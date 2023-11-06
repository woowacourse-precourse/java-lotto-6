package lotto.validator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputValidator {

    private static final String INPUT_FORMAT = "^\\d+(?:,\\d+)*$";
    private static final String WRONG_NUMBER_FORMAT = "^0\\d+";
    private static final String NULL_ERROR_MESSAGE = "[ERROR] 입력 값이 null 입니다.";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 값을 입력해 주세요.";
    private static final String FORMAT_ERROR_MESSAGE = "[ERROR] 숫자와 구분자 쉼표(,)로 구분한 숫자들만 입력할 수 있습니다.";
    private static final String WRONG_NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자는 0으로 시작할 수 없습니다.";

    private InputValidator() {
    }

    public static void validate(final String input) {
        validateNull(input);
        validateEmptyOrWhitespaces(input);
        validateInputFormat(input);
        validateWrongNumberFormat(input);
    }

    private static void validateNull(final String input) {
        if (Objects.isNull(input)) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private static void validateEmptyOrWhitespaces(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }

    private static void validateInputFormat(final String input) {
        Pattern pattern = Pattern.compile(INPUT_FORMAT);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

    private static void validateWrongNumberFormat(final String input) {
        Pattern pattern = Pattern.compile(WRONG_NUMBER_FORMAT);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException(WRONG_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

}
