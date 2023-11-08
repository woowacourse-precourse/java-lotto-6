package lotto.view;

import java.util.regex.Pattern;
import java.util.List;
import lotto.constant.Constant;
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
            throw new IllegalArgumentException(Message.ERROR_INPUT_SPACED.getMessage());
        }
    }

    static void validateNonZeroLeadingParsableNumber(String userInput) {
        if (!ONLY_NUMBER.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_NOT_ONLY_NUMBER.getMessage());
        }
        if (ZERO_LEADING_NUMBER.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_ZERO_LEADING_NUMBER.getMessage());
        }
        if (NON_PARSABLE_NUMBER.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_NON_PARSABLE_NUMBER.getMessage());
        }
    }

    static void validateLottoNumbersPattern(String userInput) {
        if (!LOTTO_NUMBERS.matcher(userInput).matches()) {
            throw new IllegalArgumentException(Message.ERROR_INPUT_INVALID_LOTTO_NUMBERS.getMessage());
        }
    }

    static void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount < Constant.LOTTO_PRICE.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_UNDER_MINIMUM.getMessage());
        }
        if (purchaseAmount > Constant.MAXIMUM_PURCHASE_AMOUNT.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_OVER_MAXIMUM.getMessage());
        }
        if (purchaseAmount % Constant.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(Message.ERROR_PURCHASE_AMOUNT_INVALID_UNIT.getMessage());
        }
    }

    static void validateLottoNumber(int lottoNumber) {
        if (lottoNumber < Constant.MINIMUM_LOTTO_NUMBER.getValue()
                || lottoNumber > Constant.MAXIMUM_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(Message.ERROR_LOTTO_NUMBERS_OUT_OF_RANGE.getMessage());
        }
    }

    static void validateWinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(Message.ERROR_BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }
}
