package lotto.validator;

import static lotto.config.GameConfig.END_INCLUSIVE;
import static lotto.config.GameConfig.LOTTO_NUMBER_UNIT;
import static lotto.config.GameConfig.NUMBER_OF_LOTTO_NUMBERS;
import static lotto.config.GameConfig.START_INCLUSIVE;
import static lotto.exception.ExceptionMessage.DUPLICATE_NUMBER;
import static lotto.exception.ExceptionMessage.EMPTY_VALUE;
import static lotto.exception.ExceptionMessage.INVALID_WINNING_NUMBER_COUNT;
import static lotto.exception.ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.exception.ExceptionMessage.NOT_MULTIPLE_OF_THOUSAND;
import static lotto.exception.ExceptionMessage.NOT_NUMERIC_VALUE;
import static lotto.exception.ExceptionMessageBuilder.build;
import static lotto.util.MessageBuilder.buildInvalidLottoNumberRangeMessage;
import static lotto.util.MessageBuilder.buildInvalidWinningNumberMessage;
import static lotto.validator.constants.ValidationPatterns.WINNING_NUMBER_PATTERN;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import lotto.exception.LottoGameException;

public final class InputValidator {
    private InputValidator() {
    }

    private static Boolean isNull(String value) {
        return Optional.ofNullable(value).isEmpty();
    }

    private static Boolean isEmptyValue(String value) {
        return value.trim().isEmpty();
    }

    private static Boolean isNumericValue(String value) {
        return value
                .chars()
                .allMatch(Character::isDigit);
    }

    private static Boolean isValidWinningNumberFormat(String value) {
        return Pattern.matches(WINNING_NUMBER_PATTERN.getPattern(), value);
    }

    private static Boolean isValidLottoNumberRange(Integer value) {
        return START_INCLUSIVE <= value && END_INCLUSIVE >= value;
    }

    private static Boolean isMultipleOfThousand(Integer value) {
        return value % LOTTO_NUMBER_UNIT == 0;
    }

    private static Boolean checkDuplicateNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }

    private static Boolean checkLottoNumberCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw LottoGameException.of(build(buildInvalidWinningNumberMessage()));
        }

        return true;
    }

    public static Boolean validateEmptyValue(String value) {
        if (isNull(value) || isEmptyValue(value)) {
            throw LottoGameException.of(build(EMPTY_VALUE));
        }

        return true;
    }

    public static Boolean validateNumericValue(String value) {
        if (!isNumericValue(value)) {
            throw LottoGameException.of(build(NOT_NUMERIC_VALUE));
        }

        return true;
    }

    public static Boolean validateWinningNumberFormat(String value) {
        if (!isValidWinningNumberFormat(value)) {
            throw LottoGameException.of(build(INVALID_WINNING_NUMBER_FORMAT));
        }

        return true;
    }

    public static Boolean validateLottoNumberRange(Integer value) {
        if (!isValidLottoNumberRange(value)) {
            throw LottoGameException.of(build(buildInvalidLottoNumberRangeMessage()));
        }

        return true;
    }

    public static Boolean validateMultipleNumberOfThousand(Integer value) {
        if (!isMultipleOfThousand(value)) {
            throw LottoGameException.of(build(NOT_MULTIPLE_OF_THOUSAND));
        }

        return true;
    }

    public static Boolean validateDuplicateNumber(List<Integer> numbers) {
        if (!checkDuplicateNumber(numbers)) {
            throw LottoGameException.of(build(DUPLICATE_NUMBER));
        }

        return true;
    }

    public static Boolean validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw LottoGameException.of(build(DUPLICATE_NUMBER));
        }

        return true;
    }

    public static Boolean validateLottoNumberCount(List<Integer> lottoNumbers) {
        if (!checkLottoNumberCount(lottoNumbers)) {
            throw LottoGameException.of(build(INVALID_WINNING_NUMBER_COUNT));
        }

        return true;
    }
}
