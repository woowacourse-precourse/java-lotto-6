package lotto.domain;

import java.util.List;
import lotto.exception.ExceptionMessage;

public class WinningNumbers {
    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumber(winningNumbers);
        this.winningNumbers = sorted(winningNumbers);
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    private void validateWinningNumber(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateDuplicate(winningNumbers);
        winningNumbers.forEach(this::validateRange);
    }

    private void validateSize(List<Integer> winningNumbers) {

        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_SIZE_EXCEPTION.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        int noDuplicate = numbers.stream().distinct().toList().size();

        if (noDuplicate != numbers.size()) {
            throw new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    private void validateRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE_EXCEPTION.getMessage());
        }
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        validateRange(bonusNumber);
        validateDuplicateBonusNumber(bonusNumber);
    }

    private void validateDuplicateBonusNumber(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
