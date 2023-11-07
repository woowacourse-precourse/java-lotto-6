package lotto.domain;

import lotto.constant.Errors;

public class Bonus {
    private final int bonusNumber;

    public Bonus(int bonusNumber) {
        validateBonusRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

    private void validateBonusRange(int number){
        if (number < 1 || number > 45){
            throw new IllegalArgumentException(Errors.WINNING_NUMBER_WRONG_RANGE_MESSAGE.getErrorMessage());
        }
    }
}
