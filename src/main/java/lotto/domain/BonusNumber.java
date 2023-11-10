package lotto.domain;

import static lotto.validator.Validator.validateBonusNumber;

import java.util.List;

public class BonusNumber {
    private final int bonus;

    public BonusNumber(List<Integer> mainNumbers, int bonus) {
        validateBonusNumber(mainNumbers, bonus);
        this.bonus = bonus;
    }

    public boolean isBonusNumber(int number) {
        return bonus == number;
    }
}
