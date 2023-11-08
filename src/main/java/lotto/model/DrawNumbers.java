package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DrawNumbers {
    private static final int FIRST_ELEMENT = 0;
    private static final int TOTAL_NUMBER_LENGTH = 7;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public DrawNumbers(List<Integer> winningNumbers, List<Integer> bonusNumber) throws IllegalArgumentException{
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber.get(FIRST_ELEMENT);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, List<Integer> bonusNumber) throws IllegalArgumentException {
        validateDigits(winningNumbers, bonusNumber);
        validateOverlap(winningNumbers, bonusNumber.get(FIRST_ELEMENT));
        validateNumRange(winningNumbers, bonusNumber.get(FIRST_ELEMENT));
    }

    private void validateDigits(List<Integer> winningNumbers, List<Integer> bonusNumber) throws IllegalArgumentException {
        if (winningNumbers.size() != Rule.LOTTO_NUMBERS_DIGITS.value()) {
            throw new IllegalArgumentException(ErrorMessages.NOT_MATCHED_DIGITS_FOR_NUMBERS.value());
        }

        if (bonusNumber.size() != Rule.BONUS_NUMBER_DIGITS.value()) {
            throw new IllegalArgumentException(ErrorMessages.NOT_MATCHED_DIGITS_FOR_BONUS_NUMBER.value());
        }
    }

    private void validateOverlap(List<Integer> winningNumbers, int bonusNumber) throws IllegalArgumentException{
        Set<Integer> wholeNumbers = new HashSet<>(winningNumbers);
        wholeNumbers.add(bonusNumber);

        if (wholeNumbers.size() != TOTAL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.NOT_ALLOW_OVERLAP.value());
        }
    }

    private void validateNumRange(List<Integer> winningNumbers, int bonusNumber) throws IllegalArgumentException {
        winningNumbers.forEach(number -> {
            if (number < Rule.MIN_NUMBER.value() || number > Rule.MAX_NUMBER.value()) {
                throw new IllegalArgumentException(ErrorMessages.NUMBER_OUT_OF_RANGE.value());
            }
        });

        if (bonusNumber < Rule.MIN_NUMBER.value() || bonusNumber > Rule.MAX_NUMBER.value()) {
            throw new IllegalArgumentException(ErrorMessages.NUMBER_OUT_OF_RANGE.value());
        }
    }
}
