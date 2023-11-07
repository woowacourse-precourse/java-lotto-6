package lotto.domain;


import lotto.constant.LottoConstant;


import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_FORM;
import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_VALUE;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(WinningNumber winningNumber, int bonusNumber) {
        validateBonusNumber(winningNumber, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(WinningNumber winningNumber, int bonusNumber) {
        validateBonusNumberDuplicate(winningNumber, bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberDuplicate(WinningNumber winningNumber, int bonusNumber) {
        if (winningNumber.isContainNumber(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_VALUE.getMessage());
        }
    }

    private void validateBonusNumberRange(int number) {
        if (number < LottoConstant.MIN_NUMBER || number > LottoConstant.MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORM.getMessage());
        }
    }

    public boolean isHitBonusNumber(Lotto lotto) {
        return lotto.isContainNumber(bonusNumber);
    }
}
