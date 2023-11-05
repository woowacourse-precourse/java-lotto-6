package lotto.domain;

import static lotto.common.ErrorMessages.NOT_IN_1000_UNIT;

import lotto.exception.InputValidationException;

public class LottoPurchaseCost {
    public static final int COST_PER_LOTTO = 1000;

    private int lottoPurchaseCost;

    public LottoPurchaseCost(int lottoPurchaseCost) {
        validateMoney(lottoPurchaseCost);
        this.lottoPurchaseCost = lottoPurchaseCost;
    }

    private void validateMoney(int lottoPurchaseCost) {
        if (!isDivisibleByThousand(lottoPurchaseCost)) {
            throw new InputValidationException(NOT_IN_1000_UNIT);
        }
    }

    private boolean isDivisibleByThousand(int lottoPurchaseCost) {
        return lottoPurchaseCost % COST_PER_LOTTO != 0;
    }

    public int getDividedThousandWonCount() {
        return lottoPurchaseCost / COST_PER_LOTTO;
    }

    public int getLottoPurchaseCost() {
        return lottoPurchaseCost;
    }
}
