package lotto.domain;

import java.util.List;

import static lotto.configuration.Constants.*;
import static lotto.configuration.LottoConfig.*;

public class Bonus {
    private int bonus;

    public Bonus(int bonus, Lotto winningLotto) {
        validate(bonus, winningLotto);
        this.bonus = bonus;
    }

    private void validate(int bonus, Lotto winningLotto) {
        validateRange(bonus);
        validateDuplicate(bonus, winningLotto);
    }

    private void validateRange(int bonus) {
        if (bonus < START.getValue() || bonus > END.getValue()) {
            throw new IllegalArgumentException(Errors.MESSAGE + Errors.LOTTO_IS + START.getValue() + Errors.FROM + END.getValue() + Errors.MUST_CHECK_RANGE);
        }
    }

    private void validateDuplicate(int bonus, Lotto winningLotto) {
        List<Integer> numbers = winningLotto.getNumbers();
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(Errors.MESSAGE + Errors.BONUS_MUST_NOT_DUPLICATE);
        }
    }

    public int getBonus() {
        return bonus;
    }
}
