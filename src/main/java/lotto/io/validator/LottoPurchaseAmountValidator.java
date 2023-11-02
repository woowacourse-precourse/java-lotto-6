package lotto.io.validator;

import lotto.domain.User;

import static lotto.exception.ExceptionMessage.InputException.PURCHASE_AMOUNT_MUST_BE_POSITIVE;
import static lotto.exception.ExceptionMessage.InputException.PURCHASE_AMOUNT_MUST_MEET_SPECIFIC_UNIT;

public class LottoPurchaseAmountValidator extends InputValidator {
    @Override
    void validate(final String userInput) {
        validateInputHasSpace(userInput);
        validateInputIsNumeric(userInput);

        final int purchaseAmount = Integer.parseInt(userInput);
        validatePurchaseAmountIsPositive(purchaseAmount);
        validatePurchaseAmountCanDivideViaUnit(purchaseAmount);
    }

    private void validatePurchaseAmountIsPositive(final int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_MUST_BE_POSITIVE.message);
        }
    }

    private void validatePurchaseAmountCanDivideViaUnit(final int purchaseAmount) {
        if (purchaseAmount % User.LOTTO_PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_MUST_MEET_SPECIFIC_UNIT.message);
        }
    }
}
