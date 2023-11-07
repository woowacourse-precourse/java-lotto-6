package lotto.domain;


import static lotto.constants.constants.INITIAL_COUNT;
import static lotto.constants.constants.LOTTO_COST;

import lotto.validation.CostValidator;

public class Cost {
    private final int cost;
    private int count;

    public Cost(Integer number) {
        CostValidator.validateParsedCost(number);
        resetCount();
        this.cost = number;
    }

    public boolean buyingLotto() {
        if (count < (cost / LOTTO_COST)) {
            count++;
            return true;
        }
        return false;
    }

    public void resetCount() {
        this.count = INITIAL_COUNT;
    }

    public int getCost() {
        return cost;
    }
}
