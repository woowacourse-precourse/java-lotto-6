package lotto.domain;

import lotto.constant.ConfigurationNumbers;
import lotto.constant.ExceptionMessage;

public class BonusNumber {
    private final int bonus;

    public BonusNumber(int bonus) {
        isOutOfRange(bonus);
        this.bonus = bonus;
    }

    private void isOutOfRange(int bonus) {
        if (bonus < ConfigurationNumbers.MIN_NUMBER.getNumber()
                || bonus > ConfigurationNumbers.MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
