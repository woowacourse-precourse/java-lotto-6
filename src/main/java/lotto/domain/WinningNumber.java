package lotto.domain;

import java.util.List;
import lotto.exception.ExceptionMessage;

public class WinningNumber {
    private static final int WINNING_NUMBER_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final List<Integer> winningNumber;
    private int bonusNumber;

    public WinningNumber(List<Integer> winningNumber) {
        validateWinningNumber(winningNumber);
        this.winningNumber = sorted(winningNumber);
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    private void validateWinningNumber(List<Integer> winningNumber) {
        validateSize(winningNumber);
        validateDuplicate(winningNumber);
        winningNumber.forEach(this::validateRange);
    }

    private void validateSize(List<Integer> winningNumber) {

        if (winningNumber.size() != WINNING_NUMBER_SIZE) {
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
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
