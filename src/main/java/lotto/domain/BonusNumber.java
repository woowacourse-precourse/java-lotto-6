package lotto.domain;


import java.util.List;

import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_FORM;
import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_VALUE;

public class BonusNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

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
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORM.getMessage());
        }
    }

    public boolean isHitBonusNumber(Lotto lotto){
        return lotto.isContainNumber(bonusNumber);
    }
}
