package lotto.lottery;

import lotto.exception.InputValidator;
import java.util.List;

public class Bonus {
    private static int bonus;
    private static List<Integer> winningNumbers;

    public Bonus(String bonus, List<Integer> winningNumbers) {
        this.bonus = Integer.parseInt(bonus);
        this.winningNumbers = winningNumbers;
        checkBonusNumber(bonus);
    }

    public int getBonus() {
        return bonus;
    }

    private void checkBonusNumber(String bonus) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkBonusNumber(this.bonus, winningNumbers);
        inputValidator.checkInputValue(bonus);
    }
}
