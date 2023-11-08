package lotto.domain.lotto;

import lotto.domain.validator.LottoValidator;

public class BonusNumber {
    private final int bonusNumber;

    private BonusNumber(int bonusNumber) {
        LottoValidator.verifyBonusNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber from(int bonusNumber) {
        return new BonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
