package lotto.model;

import lotto.util.Validation;
import lotto.view.InputView;

public class BonusNum {
    private int bonusNum;

    public BonusNum() {
        this.bonusNum = 0;
    }

    public Integer getBonusNum(String input) {
        bonusNum = validate(input);
        return bonusNum;
    }
    public int validate(String input) {
        int validNum = Validation.validateInteger(input);
        Validation.validateBonusNum(validNum);
        return validNum;
    }
}
