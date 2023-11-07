package lotto.model;

import static lotto.Message.ErrorMessage.*;
import static lotto.config.LottoConfig.*;
import java.util.List;

public class BonusLotto {
    private final int bonusNumber;

    public BonusLotto(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers == null) {
            throw new NullPointerException(OBJECT_IS_NULL.getMessage());
        }
            rangeValidate(bonusNumber);
            isDuplicate(bonusNumber, winningNumbers);
            this.bonusNumber = bonusNumber;
    }

    private void rangeValidate(int bonusNumber) {
        if (bonusNumber < LOTTO_VALUE_MIN.getValue() || bonusNumber > LOTTO_VALUE_MAX.getValue()) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private void isDuplicate(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.stream()
                .anyMatch(n -> n.equals(bonusNumber))) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_DUPLICATE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
