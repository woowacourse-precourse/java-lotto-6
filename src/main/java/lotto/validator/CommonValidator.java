package lotto.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.constant.ErrorMessage.ENTER_PROPER_NATURAL_NUMBER;
import static lotto.constant.NumericConstant.DIGIT_COUNT_LIMIT;

public class CommonValidator {
    private static final Pattern naturalNumberPattern = Pattern.compile(String.format("[0-9]{1,%d}", DIGIT_COUNT_LIMIT));
    private CommonValidator() {
    }

    public static void validateIsNaturalNumber(String input) {
        Matcher matcher = naturalNumberPattern.matcher(input);

        if(!matcher.matches()) {
            throw new IllegalArgumentException(ENTER_PROPER_NATURAL_NUMBER);
        }
    }
}
