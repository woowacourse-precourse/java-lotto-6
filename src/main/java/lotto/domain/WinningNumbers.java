package lotto.domain;

import java.util.List;

import static lotto.message.Error.LOTTO_NUMBER_DUPLICATE;
import static lotto.message.Error.LOTTO_NUMBER_OUT_OF_RANGE;

public class WinningNumbers extends Lotto {
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) throws IllegalArgumentException {
        super(numbers);
        validateLottoRange(bonusNumber);
        validateDuplicateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_DUPLICATE.getMessage());
        }

        if (isNotValidRange(bonusNumber)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
