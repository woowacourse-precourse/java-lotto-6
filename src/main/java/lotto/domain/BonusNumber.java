package lotto.domain;

import lotto.validation.Validation;
import lotto.validation.bonusnumber.domain.BonusNumberRangeCondition;
import lotto.validation.bonusnumber.input.BonusNumberTypeCondition;

public class BonusNumber {
    private static final Validation bonusNumberValidation;
    private static final Validation inputValidation;
    private final static int MAX_NUM = 45;
    private final static int MIN_NUM = 1;
    private final int bonusNumber;


    public BonusNumber(String stringNumber) {
        inputValidation.validate(stringNumber);
        int bonusNumber = Integer.parseInt(stringNumber);
        bonusNumberValidation.validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    static {
        inputValidation = new Validation(
                new BonusNumberTypeCondition()
        );

        bonusNumberValidation = new Validation(
                new BonusNumberRangeCondition(MIN_NUM, MAX_NUM)
        );
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
