package lotto.domain;

import lotto.constants.IntegerConstants;
import lotto.exceptions.DuplicateException;
import lotto.exceptions.InvalidNumberException;

public class LottoBonus {
    Integer bonus;

    public LottoBonus(LottoWinning winning, Integer bonus) {
        validate(winning, bonus);
        this.bonus = bonus;
    }

    public Integer getBonus() {
        return bonus;
    }

    private void validate(LottoWinning winning, Integer bonus) {
        if (winning.getWinnings().contains(bonus)) {
            throw new DuplicateException();
        }

        if (bonus < IntegerConstants.LOTTO_RANGE_START || bonus > IntegerConstants.LOTTO_RANGE_END) {
            throw new InvalidNumberException();
        }
    }
}
