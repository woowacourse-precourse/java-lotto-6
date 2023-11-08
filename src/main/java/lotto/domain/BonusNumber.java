package lotto.domain;

import lotto.view.ErrorMessage;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int number) {
        validate(number);
        this.bonusNumber = number;
    }

    private void validate(int number) {
        if (number > 45 || number < 1) {
            ErrorMessage.verificationViewRangeInputBonusNumber();
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
