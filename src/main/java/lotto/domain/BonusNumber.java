package lotto.domain;

import lotto.util.Validator;

public record BonusNumber(int value) {

    public BonusNumber {
        Validator.validateBonusNumber(value);
    }

    public boolean isIn(Lotto answerNumber) {
        return answerNumber.contains(value);
    }
}
