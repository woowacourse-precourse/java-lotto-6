package lotto.lottery;

import lotto.exception.InputValidator;

public class Bonus {
    private static int bonus;

    public Bonus(String bonus){
        this.bonus = Integer.parseInt(bonus);
        checkBonusNumber(bonus);
    }

    private void checkBonusNumber(String bonus){
        InputValidator inputValidator = new InputValidator();
        inputValidator.checkBonusNumber(this.bonus);
        inputValidator.checkInputValue(bonus);
    }
}
