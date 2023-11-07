package lotto.domain;


import static lotto.constants.Constants.INITIAL_COUNT;
import static lotto.constants.Constants.LOTTO_COST;

import lotto.validation.CostValidator;

public class Cost {
    private final int cost;
    private int count;

    public Cost(Integer number) {
        CostValidator.validateParsedCost(number);
        resetCount();
        this.cost = number;
    }

    public boolean hasMoney() {
        return count < (cost / LOTTO_COST);
    }

    public void buyingLotto() {
        count++;
    }

    public void resetCount() {
        this.count = INITIAL_COUNT;
    }

    public int getCost() {
        return cost;
    }

    public int getDivideCost() {
        return cost / LOTTO_COST;
    }
}
