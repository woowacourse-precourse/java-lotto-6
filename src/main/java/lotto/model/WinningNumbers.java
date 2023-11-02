package lotto.model;

import java.util.List;

public class WinningNumbers {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final String WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE = "[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.";

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateNumberInRange(winningNumbers);
        validateWinningNumbersCount(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateNumberInRange(List<Integer> winningNumbers) {
        for (final Integer winningNumber : winningNumbers) {
            if (isWinningNumberValid(winningNumber)) {
                throw new IllegalArgumentException(WINNING_NUMBER_OUT_OF_RANGE_EXCEPTION_MESSAGE);
            }
        }
    }

    private boolean isWinningNumberValid(Integer winningNumber) {
        return winningNumber < START_NUMBER || winningNumber > END_NUMBER;
    }

    private void validateWinningNumbersCount(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개 입력해야 합니다.");
        }
    }
}
