package lotto.domain;

import lotto.exception.InputException;

import static lotto.configuration.GameConfiguration.MAX_LOTTO_NUMBER;
import static lotto.configuration.GameConfiguration.MIN_LOTTO_NUMBER;
import static lotto.exception.errorcode.InputErrorCode.INVALID_BONUS_NUMBER_RANGE;

public class Bonus {
    private final int number;

    public Bonus(final int number) {
        validateBonusNumber(number);
        this.number = number;
    }

    public boolean containNumber(final Lotto lotto) {
        return lotto.contains(number);
    }

    private void validateBonusNumber(final int number) {
        if (MIN_LOTTO_NUMBER > number || MAX_LOTTO_NUMBER < number) {
            throw new InputException(INVALID_BONUS_NUMBER_RANGE);
        }
    }
}
