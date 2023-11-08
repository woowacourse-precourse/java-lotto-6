package lotto.domain;

import static lotto.configuration.ErrorMessage.*;
import static lotto.configuration.GameConfig.*;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (isMultipleOfUnit(amount)) {
            throw new IllegalArgumentException(PURCHASE_UNIT);
        }
    }

    public int toNumberOfLottos() {
        return amount / PURCHASE_MONEY_UNIT;
    }

    private static boolean isMultipleOfUnit(int amount) {
        return amount % PURCHASE_MONEY_UNIT != 0;
    }
}
