package lotto.domain;

import lotto.utils.Validator;

public class BonusNumber {
    private Integer bonusNumber;
    public BonusNumber(String bonusNumber) {
        Validator.checkBonusNumber(Integer.parseInt(bonusNumber));
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

}
