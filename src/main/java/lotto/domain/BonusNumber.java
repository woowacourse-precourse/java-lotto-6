package lotto.domain;

import java.util.List;
import lotto.Validator.NumberValidator;
import lotto.util.Parser;

public class BonusNumber {
    private final int bonus;

    public BonusNumber(String number, List<Integer> winningNumbers) {
        int bonus = Parser.toInteger(number);
        validate(bonus, winningNumbers);
        this.bonus = bonus;
    }

    private void validate(int num, List<Integer> winningNumbers) {
        NumberValidator.isOutRange(num);
        NumberValidator.isDuplicatedBonus(num, winningNumbers);
    }

    public int getBonus() {
        return bonus;
    }
}
