package lotto.domain;

import lotto.GameConfig;

import static lotto.GameConfig.*;

public class PurchaseAmount {
    private final int amount;

    public PurchaseAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (isMultipleOfUnit(amount)) {
            throw new IllegalArgumentException("구입 금액의 최소 단위는 1,000원입니다.");
        }
    }

    public int toNumberOfLottos() {
        return amount / PURCHASE_MONEY_UNIT;
    }

    private static boolean isMultipleOfUnit(int amount) {
        return amount % PURCHASE_MONEY_UNIT != 0;
    }
}
