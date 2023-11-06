package lotto.validator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static lotto.exception.InputViewExceptionMessage.*;
import static lotto.util.CharacterUnits.*;
import static lotto.util.PatternUnits.PATTERN_FOR_FINDING_SPECIAL_SIGN;

public class InputValidator {

    private static final Pattern pattern = Pattern.compile(PATTERN_FOR_FINDING_SPECIAL_SIGN.getPattern());

    public static void validateNumber(final String input) {
        for (char token : input.toCharArray()) {
            isNumberToken(token);
        }
    }

    private static void isNumberToken(final Character token) {
        if (!(Character.isDigit(token))) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    public static void validateBlank(final String input) {
        if (input.isBlank() || input == null) {
            throw new IllegalStateException(NO_LINE_FOUND.getMessage());
        }

    }

    public static void validateInputNumbersFormat(final List<String> numbers) {
        validateSpecialSign(numbers);
        validateNumbers(numbers);
    }

    private static void validateNumbers(final List<String> numbers) {
        for (String number : numbers) {
            validateNumber(number);
        }
    }

    private static void validateSpecialSign(final List<String> numbers) {
        for (String number : numbers) {
            isSpecialSignToken(number);
        }
    }

    private static void isSpecialSignToken(final String number) {
        if (pattern.matcher(number)
                .find()) {
            throw new IllegalArgumentException(FOUND_SPECIAL_SIGN.getMessage());
        }

    }

}
