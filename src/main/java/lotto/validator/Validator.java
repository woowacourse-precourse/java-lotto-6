package lotto.validator;

import static lotto.view.ViewConstant.MAIN_NUMBER_PATTERN;
import static lotto.view.ViewConstant.NUMBER_PATTERN;

import java.util.List;
import lotto.LottoRule;

public class Validator {

    public static void validateNumeric(String input) {
        if (notMatches(input, NUMBER_PATTERN.value())) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC_INPUT.message());
        }
    }

    public static void validateMainNumbersInput(String input) {
        if (notMatches(input, MAIN_NUMBER_PATTERN.value())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT_WINNING_NUMBERS.message());
        }
    }

    private static boolean notMatches(String target, String pattern) {
        return (!target.matches(pattern));
    }

    public static void validatePayment(int value) {
        validatePositive(value);
        validatePaymentUnit(value);
    }

    private static void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT.message());
        }
    }

    private static void validatePaymentUnit(int value) {
        if (hasRemainder(value, LottoRule.LOTTO_PRICE.value())) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PAYMENT.message());
        }
    }

    private static boolean hasRemainder(int dividend, int divider) {
        return (dividend % divider) != 0;
    }

    public static void validateMainNumbers(List<Integer> mainNumbers) {
        validateMainNumbersSize(mainNumbers);
        validateMainNumbersInRange(mainNumbers);
        validateMainNumbersNotDuplicated(mainNumbers);
    }

    private static void validateMainNumbersNotDuplicated(List<Integer> winningNumbers) {
        if (isDuplicated(winningNumbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_MAIN_NUMBER.message());
        }
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    private static void validateMainNumbersInRange(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(Validator::outOfRange)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_WINNING_NUMBER.message());
        }
    }

    private static boolean outOfRange(int value) {
        return !(LottoRule.LOTTO_NUMBER_START.value() <= value && value <= LottoRule.LOTTO_NUMBER_END.value());
    }

    private static void validateMainNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LottoRule.LOTTO_NUMBER_COUNT.value()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUM_MAIN_NUMBER.message());
        }
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonus) {
        validateBonusInRange(bonus);
        validateBonusNotDuplicated(winningNumbers, bonus);
    }

    private static void validateBonusNotDuplicated(List<Integer> winningNumbers, int bonus) {
        if (winningNumbers.contains(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.message());
        }
    }

    private static void validateBonusInRange(int bonus) {
        if (outOfRange(bonus)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_WINNING_NUMBER.message());
        }
    }
}
