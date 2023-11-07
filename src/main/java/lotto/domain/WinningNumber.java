package lotto.domain;

import lotto.constant.ErrorMessages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.NumberConstants.*;

public class WinningNumber {

    private final List<Integer> winningNumber;

    public WinningNumber(List<Integer> winningNumber) {
        checkCorrectNumberSize(winningNumber);
        checkDuplicateNumber(winningNumber);
        checkCorrectRange(winningNumber);
        this.winningNumber = winningNumber;
    }

    private void checkCorrectNumberSize(List<Integer> winningNumber) {
        if (isIncorrectNumberSize(winningNumber)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_COUNT.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static boolean isIncorrectNumberSize(List<Integer> winningNumber) {
        return winningNumber.size() != WINNING_NUMBER;
    }

    private void checkCorrectRange(List<Integer> winningNumber) {
        if (isIncorrectRange(winningNumber)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.INVALID_RANGE.format(NUMBER_RANGE_MIN, NUMBER_RANGE_MAX) +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static boolean isIncorrectRange(List<Integer> winningNumber) {
        return winningNumber.stream()
                .anyMatch(num -> num < NUMBER_RANGE_MIN || num > NUMBER_RANGE_MAX);
    }

    private void checkDuplicateNumber(List<Integer> winningNumber) {
        Set<Integer> uniqueNumber = new HashSet<>(winningNumber);

        if (hasDuplicateNumber(uniqueNumber)) {
            throw new IllegalArgumentException(ErrorMessages.PREFIX.getMessage() +
                    ErrorMessages.DUPLICATE_NUMBER.getMessage() +
                    ErrorMessages.SUFFIX.getMessage());
        }
    }

    private static boolean hasDuplicateNumber(Set<Integer> uniqueNumber) {
        return uniqueNumber.size() != WINNING_NUMBER;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
