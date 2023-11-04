package lotto.model;

import lotto.view.ErrorMessage;

public class BonusNumber {

    private int value;

    public BonusNumber(int value) {
        validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private void validate(int value) {
        if(value < 1 || value > 45) {
            ErrorMessage.printBonusNumberRangeError();
            throw new IllegalArgumentException();
        }
    }
}
