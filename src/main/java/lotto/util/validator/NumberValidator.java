package lotto.util.validator;

import java.util.regex.Pattern;
import lotto.exception.ExceptionMessage;

public class NumberValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    private static final Pattern LOTTO_PATTERN = Pattern.compile("^([0-9]{1,},?)+$");
    public static final String WRONG_PREFIX = "0";
    public static final int WRONG_CONDITION = 1;

    public static void isNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_INPUT.getErrorDescription());
        }
    }

    public static void isNumberPattern(String input) {
        if (!NUMBER_PATTERN.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_MATCHES_NUMBER_PATTERN.getErrorDescription());
        }
    }

    public static void isLottoPattern(String inputLotto) {
        if (!LOTTO_PATTERN.matcher(inputLotto).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_MATCHES_LOTTO_PATTERN.getErrorDescription());
        }
    }

    public static void startsWithZero(String input) {
        if (input.startsWith(WRONG_PREFIX) && input.length() > WRONG_CONDITION) {
            throw new IllegalArgumentException(ExceptionMessage.MULTIPLE_LETTERS_STARTS_WITH_ZERO.getErrorDescription());
        }
    }


}
