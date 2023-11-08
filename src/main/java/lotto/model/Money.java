package lotto.model;

import lotto.utils.constant.ErrorMessage;

public class Money {
    private static final int MIN_COST = 1000;
    private static final int MAX_COST = 100000;
    private int cost;

    public Money(int cost) {
        validateCostOutOfSize(cost);
        validateCostInUnit(cost);
        this.cost = cost;
    }

    public int getMoney() {
        return cost;
    }

    public int getLottoCount() {
        return cost / MIN_COST;
    }

    private void validateCostOutOfSize(int cost) {
        if (cost < MIN_COST || cost > MAX_COST) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_OUT_OF_SIZE_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateCostInUnit(int cost) {
        if (cost % MIN_COST != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_COST_IN_UNIT_ERROR_MESSAGE.getMessage());
        }
    }
}
