package lotto.model;

import static lotto.Message.ErrorMessage.LOTTO_RANGE_ERROR_MESSAGE;
import static lotto.config.LottoConfig.*;

public class BonusLotto {
    private final int bonusNumber;

    public BonusLotto(int bonusNumber) {
        rangeValidate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void rangeValidate(int bonusNumber) {
        if (bonusNumber < LOTTO_VALUE_MIN.getValue() || bonusNumber > LOTTO_VALUE_MAX.getValue()) {
            throw new IllegalArgumentException(LOTTO_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
