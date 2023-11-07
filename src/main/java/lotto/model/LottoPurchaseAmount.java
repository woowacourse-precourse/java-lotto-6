package lotto.model;

import lotto.exception.business.BusinessConditionException;

import static lotto.view.message.ValidationErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_THOUSAND;
import static lotto.view.message.ValidationErrorMessage.PURCHASE_AMOUNT_NOT_POSITIVE;

public class LottoPurchaseAmount {
    private final int amount;

    public LottoPurchaseAmount(int amount) {
        validatePositive(amount);
        validateMultipleOfThousand(amount);
        this.amount = amount;
    }

    private void validatePositive(int amount) {
        if (amount <= 0) {
            throw new BusinessConditionException(PURCHASE_AMOUNT_NOT_POSITIVE.getMessage());
        }
    }

    private void validateMultipleOfThousand(int amount) {
        if (amount % 1000 != 0) {
            throw new BusinessConditionException(PURCHASE_AMOUNT_NOT_MULTIPLE_THOUSAND.getMessage());
        }
    }

    public int getAmount() {
        return amount;
    }
}
