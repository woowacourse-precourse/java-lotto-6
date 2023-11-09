package lotto.model;

import lotto.validation.LottoNumberValidator;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber, WinningNumber winningNumber) {
        validate(bonusNumber, winningNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(int bonusNumber, WinningNumber winningNumber) {
        LottoNumberValidator.validateBonusNumber(bonusNumber);
        validateDuplicateBonusNumber(bonusNumber, winningNumber);
    }


    private void validateDuplicateBonusNumber(int bonusNumber, WinningNumber winningNumber) {
        LottoNumberValidator.validateDuplicateBonusNumber(
                winningNumber.getWinningNumbers(),
                bonusNumber);
    }
}
