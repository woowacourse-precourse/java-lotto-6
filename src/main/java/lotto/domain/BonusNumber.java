package lotto.domain;

import lotto.validator.BonusNumberValidator;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number, WinningLotto winningLotto) {
        BonusNumberValidator.validateBonusNumber(number, winningLotto);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
