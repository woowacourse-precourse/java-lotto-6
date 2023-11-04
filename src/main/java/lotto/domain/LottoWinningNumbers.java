package lotto.domain;

import java.util.List;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers;

    public LottoWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbersSize(winningNumbers);
        validateWinningNumberRange(winningNumbers);
        validateWinningNumberDuplicate(winningNumbers);
    }

    private void validateWinningNumbersSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개가 입력되어야 합니다.");
        }
    }

    private void validateWinningNumberRange(List<Integer> winningNumbers) {
        if (winningNumbers.stream().anyMatch(number -> number <= 0 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateWinningNumberDuplicate(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복이 될 수 없습니다.");
        }
    }

}
