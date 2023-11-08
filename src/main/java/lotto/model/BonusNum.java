package lotto.model;

import lotto.util.Validation;

public class BonusNum {

    private int bonusNum;

    public BonusNum() {
        this.bonusNum = 0;
    }

    public Integer getBonusNum(String input, Lotto lotto) {
        bonusNum = validate(input, lotto);
        return bonusNum;
    }

    public int validate(String input, Lotto lotto) {
        int validNum = Validation.validateInteger(input);
        Validation.validateNumberRange(validNum);
        Validation.validateBonusNumDuplicated(validNum, lotto.getWinningNumbers());
        return validNum;
    }
}
