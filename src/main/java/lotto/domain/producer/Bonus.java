package lotto.domain.producer;

import lotto.domain.common.Lotto;
import lotto.exception.Bonus.BonusDuplicationException;
import lotto.exception.Bonus.BonusNotInRangeException;
import lotto.exception.Bonus.BonusNotNumericException;

import java.util.List;

public record Bonus(Lotto producerLotto, int value) {

    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final String NUMERIC_REGEX = "^[0-9]*$";

    public Bonus {
        validateBonusNumeric(value);
        validateBonusDuplication(producerLotto, value);
        validateBonusNotInRange(value);
    }

    private void validateBonusNumeric(int bonus) {
        String bonusString = String.valueOf(bonus);
        if(!bonusString.matches(NUMERIC_REGEX)) {
            throw new BonusNotNumericException();
        }
    }

    private void validateBonusDuplication(Lotto lotto, int bonus) {
        List<Integer> numbers = lotto.numbers();
        if (numbers.contains(bonus)) {
            throw new BonusDuplicationException();
        }
    }

    private void validateBonusNotInRange(int bonus) {
        if (bonus < LOTTO_MIN_NUMBER || bonus > LOTTO_MAX_NUMBER) {
            throw new BonusNotInRangeException();
        }
    }
}
