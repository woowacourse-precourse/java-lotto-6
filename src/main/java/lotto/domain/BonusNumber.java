package lotto.domain;

import lotto.LottoConfig;
import lotto.ErrorMessages;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int number) {
        isNumberInRange(number);
        bonusNumber = number;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void isNumberInRange(int bonusNumber) {
        if (bonusNumber < LottoConfig.MIN_LOTTO_NUMBER || bonusNumber > LottoConfig.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_OUT_OF_RANGE_LOTT_NUMBER.getMessage());
        }
    }
}
