package lotto.domain;

import static lotto.constant.CostConstant.UNIT;

import lotto.exception.InvalidInput;

public class Cost {
    private final int paidCost;

    public Cost(String paidCost) {
        this.paidCost = validate(paidCost);;
    }

    public int getQuantity() {
        return paidCost / UNIT.getValue();
    }

    private int validate(String cost) {
        InvalidInput invalidInput = new InvalidInput();

        if (invalidInput.notIntegerValueException(cost)) {
            throw new IllegalArgumentException();
        } else if (invalidInput.notThousandUnitException(Integer.parseInt(cost))) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(cost);
    }
}
