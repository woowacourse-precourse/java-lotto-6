package lotto.domain;

import lotto.util.Validator;

public class BonusNumber {

    private final int value;

    public BonusNumber(int value) {
        Validator.validateBonusNumber(value);
        this.value = value;
    }

    public boolean isIn(Lotto answerNumber) {
        return answerNumber.contains(value);
    }
}
