package lotto.domain;


import static lotto.constants.constants.INITIAL_COUNT;
import static lotto.constants.constants.LOTTO_COST;

import lotto.validation.CostValidator;

public class Cost {
    private final int number;
    private int count;

    public Cost(Integer number) {
        CostValidator.validateParsedCost(number);
        resetCount();
        this.number = number;
    }

    public boolean buyingLotto() {
        if (count < (number / LOTTO_COST)) {
            count++;
            return true;
        }
        return false;
    }

    public void resetCount() {
        this.count = INITIAL_COUNT;
    }
}
