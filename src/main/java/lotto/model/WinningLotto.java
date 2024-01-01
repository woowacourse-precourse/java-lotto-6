package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateDistinctBonusNumbers(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDistinctBonusNumbers(int bonusNumber) {
        if (super.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
