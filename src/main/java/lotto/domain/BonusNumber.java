package lotto.domain;

import java.util.List;
import lotto.config.LottoConfig;
import lotto.exception.Errors;

public class BonusNumber {

    private final int value;

    public BonusNumber(int value, Lotto winningNumbers) {
        validateBonusNumber(value, winningNumbers);
        this.value = value;
    }

    private void validateBonusNumber(int bonusNumber, Lotto winningNumbers) {
        List<Integer> numbers = winningNumbers.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw Errors.INVALID_BONUS_NUMBER.getLottoException();
        }
        if (LottoConfig.MIN_NUMBER > bonusNumber || bonusNumber > LottoConfig.MAX_NUMBER) {
            throw Errors.INVALID_RANGE.getLottoException();
        }
    }

    public int getValue() {
        return value;
    }
}
