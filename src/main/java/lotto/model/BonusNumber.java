package lotto.model;

import java.util.List;
import lotto.LottoValue;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateRange(bonusNumber);
        validateDuplication(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < LottoValue.MINIMUM_LOTTO_NUMBER.getValue()
                || LottoValue.MAXIMUM_LOTTO_NUMBER.getValue() < bonusNumber) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public int bonusNumber() {
        return this.bonusNumber;
    }
}
