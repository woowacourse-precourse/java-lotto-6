package lotto.domain;

import java.util.List;
import lotto.Lotto;
import lotto.exception.Errors;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber, Lotto winningNumbers) {
        validateBonusNumber(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, Lotto winningNumbers) {
        List<Integer> numbers = winningNumbers.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw Errors.INVALID_BONUS_NUMBER.getException();
        }
    }

}
