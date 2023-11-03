package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Winning {

    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    public Winning(List<Integer> winningNumbers, Integer bonusNumber) {
        validateWinningNumbers(winningNumbers);
        validateBonusNumber(bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumberSize(winningNumbers);
        validateWinningNumbersRange(winningNumbers);
        validateWinningNumberDuplicated(winningNumbers);
    }

    private static void validateWinningNumberSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리 숫자여야 합니다.");
        }
    }

    private static void validateWinningNumbersRange(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (winningNumber <= 0 | winningNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1 에서 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void validateWinningNumberDuplicated(List<Integer> winningNumbers) {
        HashSet<Integer> winningNumbersWithoutDuplication = new HashSet<>(winningNumbers);
        if (winningNumbers.size() != winningNumbersWithoutDuplication.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에는 중복되는 숫자가 없어야 합니다.");
        }
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (bonusNumber <= 0 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 에서 45 사이의 숫자여야 합니다.");
        }
    }
}
