package lotto.model;


import static lotto.util.validators.BonusNumberValidator.validateBonusNumber;


public class BonusNumber {
    private final Integer bonusNumber;

    public BonusNumber(String bonusNumber, WinningNumbers winningNumbers) {
        validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = Integer.valueOf(bonusNumber);
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
