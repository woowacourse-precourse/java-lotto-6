package lotto.model;

import static lotto.Message.ErrorMessage.LOTTO_RANGE_ERROR_MESSAGE;
import static lotto.Message.ErrorMessage.BONUS_LOTTO_IS_DUPLICATE;
import static lotto.config.LottoConfig.*;

import java.util.List;

public class BonusLotto {
    private final int bonusNumber;

    public BonusLotto(int bonusNumber, List<Integer> numbers) {
        rangeValidate(bonusNumber);
        isDuplicate(bonusNumber, numbers);
        this.bonusNumber = bonusNumber;
    }

    private void rangeValidate(int bonusNumber) {
        if (bonusNumber < LOTTO_VALUE_MIN.getValue() || bonusNumber > LOTTO_VALUE_MAX.getValue()) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private void isDuplicate(int bonusNumber, List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(n -> n.equals(bonusNumber))) {
            throw new IllegalArgumentException(BONUS_LOTTO_IS_DUPLICATE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
