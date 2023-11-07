package domain;

import validator.BonusNumberValidator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(Lotto winningNumbers, String bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validate(Lotto winningNumbers, String bonusNumber) {
        BonusNumberValidator.isNumeric(bonusNumber);
        BonusNumberValidator.inRange(bonusNumber);
        BonusNumberValidator.duplicate(winningNumbers, bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
