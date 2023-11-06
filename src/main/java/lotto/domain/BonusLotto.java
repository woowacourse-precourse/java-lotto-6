package lotto.domain;

import lotto.validator.BonusValidator;

public class BonusLotto {

    private final int bonusNumber;

    public BonusLotto(int bonusNumber) {
        BonusValidator.validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
