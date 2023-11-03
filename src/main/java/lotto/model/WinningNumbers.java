package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private static final int WINNING_NUMBERS_SIZE = 6;
    private static final int WINNING_NUMBERS_RANGE_END = 45;
    private static final int WINNING_NUMBERS_RANGE_START = 1;

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        validateDuplicate(winningNumbers);
        validateRange(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> winningNumbers) {
        Set duplicateCheck = new HashSet(winningNumbers);
        if (duplicateCheck.size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복되는 값이 존재하지 않아야 합니다.");
        }
    }

    private void validateRange(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            validateSingleNumberRange(winningNumber);
        }
    }

    private void validateSingleNumberRange(int winningNumber) {
        if (winningNumber > WINNING_NUMBERS_RANGE_END || winningNumber < WINNING_NUMBERS_RANGE_START) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45까지의 숫자여야 합니다.");
        }
    }
}
