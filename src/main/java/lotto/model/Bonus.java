package lotto.model;

import static lotto.exception.ExceptionMessage.MESSAGE_RANGE_NUMBER;
import static lotto.utils.Constants.MAX_LOTTO_NUMBER;
import static lotto.utils.Constants.MIN_LOTTO_NUMBER;

import lotto.exception.ClientException;

public class Bonus {

    private int bonus;

    public Bonus(final int bonus) {
        validateRange(bonus);
        this.bonus = bonus;
    }

    private void validateRange(int bonus) {
        if (bonus < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < bonus) {
            throw new ClientException(MESSAGE_RANGE_NUMBER);
        }
    }

    public boolean compareNumber(Lotto lotto) {
        return lotto.containNumber(bonus);
    }
}
