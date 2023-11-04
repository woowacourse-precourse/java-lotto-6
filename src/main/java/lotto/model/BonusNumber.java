package lotto.model;

import java.util.List;
import lotto.ErrorMessages;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
//        validateDuplication(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException(ErrorMessages
                    .OUT_OF_RANGE
                    .getMessage());
        }
    }

//    private void validateDuplication(int bonusNumber) {
//        if (contains(bonusNumber)) {
//            throw new IllegalArgumentException(ErrorMessages
//                    .DUPLICATE_NUMBER
//                    .getMessage());
//        }
//    }
}
