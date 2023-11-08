package lotto.domain;

import static lotto.view.constatnt.Constant.MAX_LENGTH;
import static lotto.view.constatnt.Constant.MIN_LENGTH;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateLengthAndType(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateLengthAndType(int bonusNumber) {
        if(!(bonusNumber >= MIN_LENGTH && bonusNumber <= MAX_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}