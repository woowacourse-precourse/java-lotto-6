package lotto.domain;

import lotto.service.LottoValidator;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber) {
        LottoValidator.validateBonusRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public BonusNumber(String bonusNumber) {
        LottoValidator.validateBonus(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}
