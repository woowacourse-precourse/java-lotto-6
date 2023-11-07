package lotto.model;

import lotto.ErrorMessages;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DrawNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public DrawNumbers(List<Integer> winningNumbers, int bonusNumber) throws IllegalArgumentException{
        validateDrawNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateDrawNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateOverlap(winningNumbers, bonusNumber);
        validateDigits(winningNumbers);
        validateNumRange(winningNumbers, bonusNumber);
    }

    private void validateOverlap(List<Integer> winningNumbers, int bonusNumber) throws IllegalArgumentException{
        Set<Integer> wholeNumbers = new HashSet<>(winningNumbers);
        wholeNumbers.add(bonusNumber);

        if (wholeNumbers.size() != 7) {
            throw new IllegalArgumentException(ErrorMessages.NOT_ALLOW_OVERLAP.value());
        }
    }

    private void validateDigits(List<Integer> winningNumbers) throws IllegalArgumentException {
        if (winningNumbers.size() != Rule.LOTTO_NUMBERS_DIGITS.value()) {
            throw new IllegalArgumentException(ErrorMessages.NOT_MATCHED_DIGITS_FOR_NUMBERS.value());
        }
    }

    private void validateNumRange(List<Integer> winningNumbers, int bonusNumber) throws IllegalArgumentException {
        winningNumbers.forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessages.NUMBER_OUT_OF_RANGE.value());
            }
        });

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_OUT_OF_RANGE.value());
        }
    }
}
