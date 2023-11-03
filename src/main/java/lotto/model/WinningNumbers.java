package lotto.model;

import java.util.List;

public class WinningNumbers {

    private static final int WINNING_NUMBERS_SIZE = 6;

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateSize(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }
}
