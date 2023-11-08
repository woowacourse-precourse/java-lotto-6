package lotto.model;


import static lotto.util.Constants.ERROR;
import static lotto.util.validators.BonusNumberValidator.validateBonusNumber;

import lotto.util.exception.input.ConstructionErrorException;


public class BonusNumber {
    private final Integer bonusNumber;

    private BonusNumber(){
        throw new ConstructionErrorException();
    }

    public BonusNumber(String bonusNumber, WinningNumbers winningNumbers) {
        validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = Integer.valueOf(bonusNumber);
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
