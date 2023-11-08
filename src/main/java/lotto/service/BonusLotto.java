package lotto.service;

import static lotto.service.validator.LottoValidator.bonusNumberValidate;

public class BonusLotto {
    private final int bonusNumber;

    public BonusLotto(int bonusNumber) {
        bonusNumberValidate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
