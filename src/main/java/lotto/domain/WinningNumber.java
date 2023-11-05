package lotto.domain;

import lotto.constant.ErrorMessages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.NumberConstants.*;

public class WinningNumber {

    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        hasCorrectNumberSize(winningNumber);
        hasNoDuplicateNumber(winningNumber);
        hasCorrectRange(winningNumber);
        this.winningNumber = winningNumber;
    }

    private void hasCorrectNumberSize(List<Integer> winningNumber) {
        if (winningNumber.size() != WINNING_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_COUNT.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private void hasCorrectRange(List<Integer> winningNumber) {
        if (winningNumber.stream()
                .anyMatch(num -> num < NUMBER_RANGE_MIN || num > NUMBER_RANGE_MAX)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_RANGE.format(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX) +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private void hasNoDuplicateNumber(List<Integer> winningNumber) {
        Set<Integer> uniqueNumber = new HashSet<>(winningNumber);

        if (uniqueNumber.size() != WINNING_NUMBER) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.DUPLICATE_NUMBER.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
