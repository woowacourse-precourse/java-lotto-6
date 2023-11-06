package lotto.models;

import lotto.valid.WinNumberValidator;

public class WinNumber {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinNumber(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        WinNumberValidator.validate(lotto, bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
