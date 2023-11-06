package lotto.validator;

import java.util.regex.Pattern;

public class NumericValidator {

    private static final String INVALID_NUMBER_FORMAT
            = "[ERROR] 숫자 형식이 올바르지 않습니다.";

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d+");

    public static void validate(final String stringNumber) {
        if (isNullOrEmpty(stringNumber) || !isNumeric(stringNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
        }
    }

    private static boolean isNullOrEmpty(final String stringNumber) {
        return stringNumber == null || stringNumber.isEmpty();
    }

    private static boolean isNumeric(final String stringNumber) {
        return NUMERIC_PATTERN.matcher(stringNumber).matches();
    }
}

