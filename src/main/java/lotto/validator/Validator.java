package lotto.validator;

import static lotto.view.ViewConstant.NUMBER_PATTERN;
import static lotto.view.ViewConstant.WINNING_NUMBER_PATTERN;

import java.util.HashSet;
import java.util.List;
import lotto.LottoRule;

public class Validator {

    public static void validateNumeric(String input) {
        if (input.matches(NUMBER_PATTERN.value())) {
            return;
        }
        throw new IllegalArgumentException(Error.NOT_NUMERIC_INPUT.message());
    }

    public static void validateWinningNumbersInput(String input) {
        if (input.matches(WINNING_NUMBER_PATTERN.value())) {
            return;
        }
        throw new IllegalArgumentException(Error.INVALID_FORMAT_WINNING_NUMBERS.message());
    }

    public static void validatePayment(int value) {
        validateNotZero(value);
        validatePaymentUnit(value);
    }

    private static void validateNotZero(int value) {
        if (value > 0) {
            return;
        }
        throw new IllegalArgumentException(Error.INVALID_PAYMENT.message());
    }

    private static void validatePaymentUnit(int value) {
        if (hasNoRemainder(value, LottoRule.LOTTO_PRICE.value())) {
            return;
        }
        throw new IllegalArgumentException(Error.INVALID_PAYMENT.message());
    }

    private static boolean hasNoRemainder(int dividend, int divider) {
        return (dividend % divider) == 0;
    }

    public static void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumbersInRange(winningNumbers);
        validateWinningNumbersNotDuplicated(winningNumbers);
    }

    private static void validateWinningNumbersNotDuplicated(List<Integer> winningNumbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        if (uniqueNumbers.size() == winningNumbers.size()) {
            return;
        }
        throw new IllegalArgumentException(Error.DUPLICATED_WINNING_NUMBER.message());
    }

    private static void validateWinningNumbersInRange(List<Integer> winningNumbers) {
        if (winningNumbers.stream().allMatch(Validator::inRange)) {
            return;
        }
        throw new IllegalArgumentException(Error.INVALID_RANGE_WINNING_NUMBER.message());
    }

    private static boolean inRange(int value) {
        return LottoRule.LOTTO_NUMBER_START.value() <= value && value <= LottoRule.LOTTO_NUMBER_END.value();
    }

    private static void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() == LottoRule.LOTTO_NUMBER_COUNT.value()) {
            return;
        }
        throw new IllegalArgumentException(Error.INVALID_NUM_WINNING_NUMBER.message());
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonus) {
        validateBonusInRange(bonus);
        validateBonusNotDuplicated(winningNumbers, bonus);
    }

    private static void validateBonusNotDuplicated(List<Integer> winningNumbers, int bonus) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(Error.DUPLICATED_BONUS_NUMBER.message());
        }
    }

    private static void validateBonusInRange(int bonus) {
        if (inRange(bonus)) {
            return;
        }
        throw new IllegalArgumentException(Error.INVALID_RANGE_WINNING_NUMBER.message());
    }

}
