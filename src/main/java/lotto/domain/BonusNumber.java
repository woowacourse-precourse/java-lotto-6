package lotto.domain;

import lotto.constant.ErrorMessage;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(int bonusNumber){
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber){
        if (bonusNumber<1 || bonusNumber>45){
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
