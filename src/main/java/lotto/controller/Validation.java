package lotto.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ErrorMessages;

public class Validation {
    public void validatePayment(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages
                    .NOT_DIVISIBLE_BY_THOUSAND
                    .getMessage());
        }
    }

    public void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberDuplication(bonusNumber, winningNumbers);
    }

    public void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || 45 < bonusNumber) {
            throw new IllegalArgumentException(ErrorMessages
                     .OUT_OF_RANGE
                     .getMessage());
        }
    }

    public void validateBonusNumberDuplication(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessages
                   .DUPLICATE_NUMBER
                   .getMessage());
        }
    }
}
