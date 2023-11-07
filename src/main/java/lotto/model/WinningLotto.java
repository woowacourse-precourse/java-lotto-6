package lotto.model;

import lotto.view.ErrorConstants;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    private WinningLotto(List<Integer> numbers) {
        super(numbers);
    }

    private WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_LOTTO_NUMBER || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorConstants.ILLEGAL_LOTTO_NUMBER_ERROR);
        }
        validateBonusNumberContainInNumbers(bonusNumber);
    }

    private void validateBonusNumberContainInNumbers(int bonusNumber) {
        if (contain(bonusNumber)) {
            throw new IllegalArgumentException(ErrorConstants.BONUS_NUMBER_IN_LOTTO_NUMBERS_ERROR);
        }
    }

    public static WinningLotto create(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
