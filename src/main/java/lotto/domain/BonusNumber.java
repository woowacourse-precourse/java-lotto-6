package lotto.domain;

import java.util.List;
import lotto.constants.Messages;
import lotto.constants.Values;

public class BonusNumber {

    final private int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto winningNumbers) {
        validate(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber, Lotto winningNumbers) {
        List<Integer> winningNumber = winningNumbers.getNumbers();
        if (isDuplicateBonusNumber(bonusNumber, winningNumber)) {
            throw new IllegalArgumentException(Messages.ERROR_DUPLICATE_BONUS_NUMBER);
        }
        if(isOutsideRange(bonusNumber)) {
            throw new IllegalArgumentException(Messages.ERROR_RANGE_BONUS_NUMBER);
        }
    }

    private boolean isDuplicateBonusNumber(int bonusNumber, List<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }

    private boolean isOutsideRange(int bonusNumber) {
        return bonusNumber < Values.LOTTO_MIN_NUMBER || bonusNumber > Values.LOTTO_MAX_NUMBER;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
