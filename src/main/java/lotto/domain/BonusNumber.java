package lotto.domain;

import lotto.Config;
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
        if (bonusNumber < Config.MIN_LOTTO_NUMBER || bonusNumber > Config.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_OUT_OF_RANGE_LOTT_NUMBER.getMessage());
        }
    }
}
