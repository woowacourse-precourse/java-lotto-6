package lotto.validator;

import lotto.model.Lotto;

public class ValidateObject {
    private ValidateObject() {
    }

    public static void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }

        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}