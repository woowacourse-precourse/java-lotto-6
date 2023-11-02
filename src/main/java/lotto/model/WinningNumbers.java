package lotto.model;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        validateNumberInRange(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateNumberInRange(List<Integer> winningNumbers) {
        for (final Integer winningNumber : winningNumbers) {
            if (winningNumber < 1 || winningNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
    }
}
