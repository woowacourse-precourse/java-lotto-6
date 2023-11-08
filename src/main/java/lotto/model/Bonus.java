package lotto.model;

import lotto.exception.ClientException;
import lotto.exception.ExceptionMessage;
import lotto.utils.Constants;

public class Bonus {

    private int bonus;

    public Bonus(final int bonus) {
        validateRange(bonus);
        this.bonus = bonus;
    }

    private void validateRange(int bonus) {
        if (bonus < Constants.MIN_LOTTO_NUMBER || Constants.MAX_LOTTO_NUMBER < bonus) {
            throw new ClientException(ExceptionMessage.MESSAGE_RANGE_NUMBER);
        }
    }

    public boolean compareNumber(Lotto lotto) {
        return lotto.containNumber(bonus);
    }
}
