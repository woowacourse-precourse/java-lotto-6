package lotto.validator;

import static lotto.view.ViewConstant.NUMBER_PATTERN;
import static lotto.view.ViewConstant.WINNING_NUMBER_PATTERN;

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

}
