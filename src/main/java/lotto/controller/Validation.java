package lotto.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ErrorMessages;

public class Validation {
    public static void validatePayment(int payment) {
        if (payment % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages
                    .NOT_DIVISIBLE_BY_THOUSAND
                    .getMessage());
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        validateRange(winningNumbers);
        validateDuplication(winningNumbers);
    }

    public void validateRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || 45 < winningNumber) {
                throw new IllegalArgumentException(ErrorMessages
                      .OUT_OF_RANGE
                      .getMessage());
            }
        }
    }

    public void validateDuplication(List<Integer> winningNumbers) {
        Set<Integer> checkDuplicates = new HashSet<>(winningNumbers);

        if (checkDuplicates.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(ErrorMessages
                    .DUPLICATE_NUMBER
                    .getMessage());
        }
    }
}
