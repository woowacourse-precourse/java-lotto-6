package lotto.validator;

import static lotto.config.GameConfig.END_INCLUSIVE;
import static lotto.config.GameConfig.LOTTO_NUMBER_UNIT;
import static lotto.config.GameConfig.START_INCLUSIVE;
import static lotto.exception.ExceptionMessage.EMPTY_VALUE;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.exception.ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.exception.ExceptionMessage.NOT_MULTIPLE_OF_THOUSAND;
import static lotto.exception.ExceptionMessage.NOT_NUMERIC_VALUE;
import static lotto.exception.ExceptionMessageBuilder.build;
import static lotto.validator.constants.ValidationPatterns.WINNING_NUMBER_PATTERN;

import java.util.Optional;
import java.util.regex.Pattern;
import lotto.exception.LottoGameException;

public final class InputValidator {
    private InputValidator() {
    }

    private static boolean isNull(String value) {
        return Optional.ofNullable(value).isEmpty();
    }

    private static boolean isEmptyValue(String value) {
        return value.trim().isEmpty();
    }

    private static boolean isNumericValue(String value) {
        return value
                .chars()
                .allMatch(Character::isDigit);
    }

    private static boolean isValidWinningNumberFormat(String value) {
        return Pattern.matches(WINNING_NUMBER_PATTERN.getPattern(), value);
    }

    private static boolean isValidLottoNumberRange(Integer value) {
        return START_INCLUSIVE <= value && END_INCLUSIVE >= value;
    }

    private static boolean isMultipleOfThousand(Integer value) {
        return value % LOTTO_NUMBER_UNIT == 0;
    }

    public static boolean validateEmptyValue(String value) {
        if (isNull(value) || isEmptyValue(value)) {
            throw LottoGameException.of(build(EMPTY_VALUE));
        }

        return true;
    }

    public static boolean validateNumericValue(String value) {
        if (!isNumericValue(value)) {
            throw LottoGameException.of(build(NOT_NUMERIC_VALUE));
        }

        return true;
    }

    public static boolean validateWinningNumberFormat(String value) {
        if (!isValidWinningNumberFormat(value)) {
            throw LottoGameException.of(build(INVALID_WINNING_NUMBER_FORMAT));
        }

        return true;
    }

    public static boolean validateLottoNumberRange(Integer value) {
        if (!isValidLottoNumberRange(value)) {
            throw LottoGameException.of(build(INVALID_LOTTO_NUMBER_RANGE));
        }

        return true;
    }

    public static boolean validateMultipleNumberOfThousand(Integer value) {
        if (!isMultipleOfThousand(value)) {
            throw LottoGameException.of(build(NOT_MULTIPLE_OF_THOUSAND));
        }

        return true;
    }
}
