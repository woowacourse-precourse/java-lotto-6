package lotto.validator;

import lotto.parser.Parser;

import java.util.List;
import java.util.regex.Pattern;

import static lotto.constant.LottoConstant.RANGE_END_NUMBER;
import static lotto.constant.LottoConstant.RANGE_START_NUMBER;
import static lotto.exception.InputViewExceptionMessage.*;
import static lotto.exception.WinnerExceptionMessage.WRONG_BONUS_NUMBER_RANGE;
import static lotto.util.CharacterUnits.COMMA;
import static lotto.util.PatternUnits.PATTERN_FOR_FINDING_SPECIAL_SIGN;

public class InputValidator {

    private static final Integer FRONT = 0;
    private static final Integer GAP = 1;

    private static final Pattern pattern = Pattern.compile(PATTERN_FOR_FINDING_SPECIAL_SIGN.getPattern());

    public static void validateNumber(final String input) {
        for (char token : input.toCharArray()) {
            if (isNotNumberToken(token)) {
                throw new IllegalArgumentException(NOT_NUMBER.getMessage());
            }
        }
    }

    public static void validateRangeNumber(final String number) {
        Integer parsedNumber = Parser.parseInt(number);
        if (!(RANGE_START_NUMBER.getSetting() <= parsedNumber && RANGE_END_NUMBER.getSetting() <= 45)) {
            throw new IllegalArgumentException(WRONG_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private static Boolean isNotNumberToken(final Character token) {
        return !(Character.isDigit(token));
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

    public static void validateNumbers(final List<String> numbers) {
        for (String number : numbers) {
            validateRangeNumber(number);
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

    public static void validateCommaAtEdge(final String input) {
        if (input.charAt(FRONT) == COMMA.getUnit().charAt(FRONT)
                || input.charAt(input.length()-GAP) == COMMA.getUnit().charAt(FRONT)) {
            throw new IllegalArgumentException(FOUND_COMMA_FRONT_LAST.getMessage());
        }
    }

}
