package lotto.validator;

import java.math.BigInteger;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputValidator {

    public static final Pattern NUMBER_PATTERN = Pattern.compile("^\\d+$");

    private static final Pattern COMMON_INPUT_PATTERN = Pattern.compile("^\\d+(?:,\\d+)*$");
    private static final Pattern WRONG_NUMBER_PATTERN = Pattern.compile("^0\\d+");
    private static final String NULL_ERROR_MESSAGE = "[ERROR] 입력 값이 null 입니다.";
    private static final String BLANK_ERROR_MESSAGE = "[ERROR] 값을 입력해 주세요.";
    private static final String FORMAT_ERROR_MESSAGE = "[ERROR] 숫자와 공백 없이 쉼표(,)로 구분한 6개의 숫자들만 입력할 수 있습니다.";
    private static final String WRONG_NUMBER_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자는 0으로 시작할 수 없습니다.";
    private static final String INTEGER_RANGE_ERROR_MESSAGE = "[ERROR] int 범위를 넘어가는 숫자는 입력할 수 없습니다.";

    private InputValidator() {
    }

    public static void validate(final String input) {
        validateNull(input);
        validateEmptyOrWhitespaces(input);
        validateInputFormat(input);
        validateWrongNumberFormat(input);
        validateIntegerRange(input);
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
        Matcher matcher = COMMON_INPUT_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(FORMAT_ERROR_MESSAGE);
        }
    }

    private static void validateWrongNumberFormat(final String input) {
        Matcher matcher = WRONG_NUMBER_PATTERN.matcher(input);
        if (matcher.find()) {
            throw new IllegalArgumentException(WRONG_NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void validateIntegerRange(final String input) {
        Matcher matcher = NUMBER_PATTERN.matcher(input);
        if (matcher.find() && isOutOfIntegerRange(input)) {
            throw new IllegalArgumentException(INTEGER_RANGE_ERROR_MESSAGE);
        }
    }

    private static boolean isOutOfIntegerRange(final String input) {
        BigInteger bigInteger = new BigInteger(input);
        return bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0;
    }

}
