package lotto.domain;

import lotto.configuration.Constants;

import java.util.List;

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
            throw new IllegalArgumentException(Constants.Error.MESSAGE
                    + Constants.Error.LOTTO_IS
                    + START.getValue() + Constants.Error.FROM + END.getValue()
                    + Constants.Error.MUST_CHECK_RANGE);
        }
    }

    private void validateDuplicate(int bonus, Lotto winningLotto) {
        List<Integer> numbers = winningLotto.getNumbers();
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException(Constants.Error.MESSAGE + Constants.Error.BONUS_MUST_NOT_DUPLICATE);
        }
    }

    public int getBonus() {
        return bonus;
    }
}
