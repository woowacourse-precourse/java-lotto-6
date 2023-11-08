package lotto.domain;

import static lotto.controller.constants.ErrorMessage.DUPLICATED_BONUS_NUMBER;
import static lotto.controller.constants.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.domain.constants.LottoNumber.MAX_NUMBER;
import static lotto.domain.constants.LottoNumber.MIN_NUMBER;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(int bonusNumber) {
        checkDuplicateOfBonusNumber(bonusNumber);
        checkRangeOfBonusNumber(bonusNumber);
    }

    private void checkDuplicateOfBonusNumber(int bonusNumber) {
        if (getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    private void checkRangeOfBonusNumber(int bonusNumber) {
        if (bonusNumber < MIN_NUMBER.getValue() || bonusNumber > MAX_NUMBER.getValue()) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}