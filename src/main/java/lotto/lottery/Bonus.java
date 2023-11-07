package lotto.lottery;

import lotto.exception.InputValidator;

import java.util.List;

public class Bonus {
    private static int bonus;
    private static List<Integer> winningNumbers;
    private int bonusCount;

    public Bonus(String bonus, List<Integer> winningNumbers) {
        this.bonus = Integer.parseInt(bonus);
        this.winningNumbers = winningNumbers;
        checkBonusNumber(bonus);
    }

    public Bonus() {
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonusCount(int bonusCount) {
        this.bonusCount = bonusCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }

    private void checkBonusNumber(String bonus) {
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkBonusNumber(this.bonus, winningNumbers);
        inputValidator.checkInputValue(bonus);
    }
}
