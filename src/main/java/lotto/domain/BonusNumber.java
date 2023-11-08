package lotto.domain;

import lotto.validate.LottoValidator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto lotto) {
        this.bonusNumber = bonusNumber;
        LottoValidator.bonusNumberValidate(lotto, bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
