package lotto.domain;

import java.util.List;

public record WinningNumber(List<Integer> firstWinningNumber, int bonusNumber) {

    public WinningNumber {
        validateWinningNumber(firstWinningNumber, bonusNumber);
    }

    private void validateWinningNumber(List<Integer> firstWinningNumber, int bonusNumber) {
        if (firstWinningNumber.size() != 6) {
            throw new IllegalArgumentException();
        }

        long distinctFirstWinningNumberCount = firstWinningNumber.stream()
                .distinct()
                .count();

        if (firstWinningNumber.size() != distinctFirstWinningNumberCount) {
            throw new IllegalArgumentException();
        }

        if (firstWinningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}