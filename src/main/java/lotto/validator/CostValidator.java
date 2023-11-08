package lotto.validator;

import static lotto.constants.Message.COST_INTEGER_ERROR;
import static lotto.constants.Message.COST_MINIMUM_ERROR;
import static lotto.constants.Message.COST_UNIT_ERROR;
import static lotto.constants.Constants.MIN_COST;
import static lotto.constants.Constants.COST_UNIT;
import static lotto.constants.Constants.ZERO;

public class CostValidator {
    public int cost;

    public CostValidator() {
    }

    public void validateCost(String cost) {
        parseToInt(cost);
        isPositive();
        isPerThousand();
    }

    private void parseToInt(String cost) {
        try {
            this.cost = Integer.parseInt(cost);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(COST_INTEGER_ERROR.getErrorMessage());
        }
    }

    private void isPositive() {
        if (this.cost < MIN_COST) {
            throw new IllegalArgumentException(COST_MINIMUM_ERROR.getErrorMessage());
        }
    }

    private void isPerThousand() {
        if (this.cost % COST_UNIT != ZERO) {
            throw new IllegalArgumentException(COST_UNIT_ERROR.getErrorMessage());
        }
    }
}

