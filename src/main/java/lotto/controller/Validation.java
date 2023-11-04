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

    public static void validateWinningNumbers(Integer[] winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || 45 < winningNumber) {
                throw new IllegalArgumentException(ErrorMessages
                      .OUT_OF_RANGE
                      .getMessage());
            }
        }

        Set<Integer> checkDuplicates = new HashSet<>();
        checkDuplicates.addAll(List.of(winningNumbers));
    }
}
