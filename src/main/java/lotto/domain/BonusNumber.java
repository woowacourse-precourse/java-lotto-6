package lotto.domain;

import static lotto.view.constatnt.ErrorMessage.LENGTH_TYPE_ERROR_MESSAGE;
import static lotto.view.constatnt.Constant.*;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateLengthAndType(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateLengthAndType(int bonusNumber) {
        if(!(bonusNumber >= MIN_LENGTH && bonusNumber <= MAX_LENGTH)) {
            throw new IllegalArgumentException(LENGTH_TYPE_ERROR_MESSAGE.getMessage());
        }
    }

//    private void validateDuplicate(Lotto lotto, int bonusNumber) {
//        if(lotto.c) {
//            throw new IllegalArgumentException(LENGTH_TYPE_ERROR_MESSAGE.getMessage());
//        }
//    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}