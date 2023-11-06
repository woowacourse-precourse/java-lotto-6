package lotto.domain;


import java.util.List;

import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_FORM;
import static lotto.exception.ErrorMessage.INVALID_BONUS_NUMBER_VALUE;

public class BonusNumber {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private final int bonusNumber;

    public BonusNumber(List<Integer> winningNumber, int bonusNumber) {
        validateBonusNumber(winningNumber, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningNumber, int bonusNumber) {
        validateBonusNumberDuplicate(winningNumber, bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateBonusNumberDuplicate(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_VALUE.getMessage());
        }
    }

    private void validateBonusNumberRange(int number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER_FORM.getMessage());
        }
    }


    public int getBonusNumber() {
        return bonusNumber;
    }
}
