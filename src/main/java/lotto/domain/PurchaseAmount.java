package lotto.domain;

import static lotto.constants.Constants.MIN_PURCHASE_AMOUNT;
import static lotto.constants.Constants.NON_REMAINDER;
import static lotto.constants.ErrorMessage.AMOUNT_UNDER_THOUSAND_ERROR_MESSAGE;
import static lotto.constants.ErrorMessage.NON_THOUSAND_MULTIPLE_ERROR_MESSAGE;

public class PurchaseAmount {
    private int money;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.money = amount;
    }

    public int getMoney() {
        return money;
    }

    private void validate(int amount) {
        validateAmount(amount);
        validateIsMultipleOfThousand(amount);
    }

    private void validateAmount(int amount) {
        if (amount < MIN_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(AMOUNT_UNDER_THOUSAND_ERROR_MESSAGE);
        }
    }

    private void validateIsMultipleOfThousand(int amount) {
        if (amount % MIN_PURCHASE_AMOUNT != NON_REMAINDER) {
            throw new IllegalArgumentException(NON_THOUSAND_MULTIPLE_ERROR_MESSAGE);
        }
    }
}
