package lotto.model;

import java.util.List;

public class LottoWinningNumbers extends Lotto{
    private int bonusNumber;

    public LottoWinningNumbers(List<Integer> numbers, final int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(final int bonusNumber) {
        if (containsNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
