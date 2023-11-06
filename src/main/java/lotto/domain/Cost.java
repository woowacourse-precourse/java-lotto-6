package lotto.domain;

import static lotto.constant.CostConstant.UNIT;

import lotto.exception.InvalidInput;

public class Cost {
    private final int paidCost;
    private static boolean isValid = false;

    public Cost(int paidCost) {
        validate(paidCost);
        this.paidCost = paidCost;
    }

    public int getQuantity() {
        return paidCost / UNIT.getValue();
    }

    public boolean isValid(){
        return isValid;
    }
    private void validate(int cost){
        InvalidInput invalidInput = new InvalidInput();
        isValid = invalidInput.notThousandUnitException(cost);
    }
}
