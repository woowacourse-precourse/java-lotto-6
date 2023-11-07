package lotto.domain;

import java.util.List;
import lotto.validator.Validator;

public class BonusNumber {
    private final int bonus;

    public BonusNumber(List<Integer> mainNumbers, int bonus) {
        Validator.validateBonusNumber(mainNumbers, bonus);
        this.bonus = bonus;
    }

    public boolean isBonusNumber(int number) {
        return bonus == number;
    }

}
