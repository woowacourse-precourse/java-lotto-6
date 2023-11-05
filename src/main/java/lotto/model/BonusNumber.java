package lotto.model;

import java.util.List;
import lotto.ErrorMessages;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateRange(bonusNumber);
        validateDuplication(bonusNumber, winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException(ErrorMessages
                    .OUT_OF_RANGE
                    .getMessage());
        }
    }

    private void validateDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages
                    .DUPLICATE_NUMBER
                    .getMessage());
        }
    }
}
