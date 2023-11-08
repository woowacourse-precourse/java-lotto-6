package lotto.domain;

import lotto.validator.BonusValidator;

import java.util.List;

public class BonusLotto {

    private final String bonusNumber;
    public BonusLotto(String bonusNumber) {
        BonusValidator.validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
    public int getBonusNumber() {
        return Integer.parseInt(bonusNumber);
    }
}
