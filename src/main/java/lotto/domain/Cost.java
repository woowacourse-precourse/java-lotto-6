package lotto.domain;

import static lotto.global.constants.NumberType.COST_UNIT;

import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class Cost {
    private int cost;

    private Cost(int cost) {
        Validator.validate(cost);
        this.cost = cost;
    }

    public static Cost from(int cost) {
        return new Cost(cost);
    }

    public int getCount() {
        return cost / COST_UNIT.getValue();
    }

    private static class Validator {
        private static int validate(int cost) {
            validateUnit(cost);
            return cost;
        }

        private static void validateUnit(int cost) {
            if (isNotDivisible(cost)) {
                throw LottoException.from(ErrorMessage.INVALID_UNIT_ERROR);
            }
        }

        private static boolean isNotDivisible(int cost) {
            return cost % COST_UNIT.getValue() != 0;
        }
    }
}
