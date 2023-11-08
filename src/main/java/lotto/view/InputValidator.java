package lotto.view;

import java.util.regex.Pattern;
import lotto.constant.Message;

final class InputValidator {
    private static final Pattern NON_SPACED = Pattern.compile("^[\\S]+$");
    private static final Pattern ONLY_NUMBER = Pattern.compile("^[0-9]+$");
    private static final Pattern ZERO_LEADING_NUMBER = Pattern.compile("^[0][0-9]*$");
    private static final Pattern NON_PARSABLE_NUMBER = Pattern.compile("^[1-9][0-9]{9,}$");
    private static final Pattern LOTTO_NUMBERS = Pattern.compile("^([1-9][0-9]{0,1})(,[1-9][0-9]{0,1}){5}$");

    private InputValidator() {
    }

    static void validateNonSpaced(String userInput) {
        if (!NON_SPACED.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_SPACED.toString());
        }
    }

    static void validateNonZeroLeadingParsableNumber(String userInput) {
        if (!ONLY_NUMBER.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_NOT_ONLY_NUMBER.toString());
        }
        if (ZERO_LEADING_NUMBER.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_ZERO_LEADING_NUMBER.toString());
        }
        if (NON_PARSABLE_NUMBER.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_NON_PARSABLE_NUMBER.toString());
        }
    }

    static void validateLottoNumbersPattern(String userInput) {
        if (!LOTTO_NUMBERS.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_INVALID_LOTTO_NUMBERS.toString());
        }
    }

    static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < 1_000) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_UNDER_MINIMUM.toString());
        }
        if (purchaseAmount > 100_000) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_OVER_MAXIMUM.toString());
        }
        if (purchaseAmount % 1_000 != 0) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_INVALID_UNIT.toString());
        }
    }

    static void validateLottoNumber(int winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_NUMBERS_OUT_OF_RANGE.toString());
        }
    }
}
