package lotto.validator;

import lotto.model.Lotto;

public class ValidateObject {
    private ValidateObject() {
    }

    public static void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}