package lotto.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static final String NULL_OR_EMPTY_MESSAGE = "값을 입력해주세요";
    public static final String EMPTY = "";
    public static final String THOUSANDS_MULTIPLE_MESSAGE = "1000의 배수를 입력해주세요";
    public static final String THOUSANDS_MULTIPLE_REGEX = "^[1-9][0-9]*000$";

    public static void validateBudget(String input) throws IllegalArgumentException {
        validateNullOrEmpty(input);
        validateBudgetInThousands(input);
    }

    protected static void validateNullOrEmpty(String input) throws IllegalArgumentException {
        if (input == null || input.equals(EMPTY)) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_MESSAGE);
        }
    }

    protected static void validateBudgetInThousands(String input) throws IllegalArgumentException {
        Pattern pattern = Pattern.compile(THOUSANDS_MULTIPLE_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw  new IllegalArgumentException(THOUSANDS_MULTIPLE_MESSAGE);
        }
    }
}
