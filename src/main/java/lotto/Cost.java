package lotto;

import lotto.exception.InvalidInput;

public class Cost {
    private final int cost;
    private static final int UNIT = 10000;
    public Cost(int cost) {
        validate(cost);
        this.cost = cost;
    }
    public int calculateQuantity(){
        return cost / UNIT;
    }

    private void validate(int cost){
        InvalidInput invalidInput = new InvalidInput();
        invalidInput.notThousandUnitException(cost);
    }
}
