package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {
    public static final int WINNING_NUMBERS_SIZE = 6;

    private int bonusNumber;
    private List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateDuplicate(winningNumbers);
        validateDuplicateBonus(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(List<Integer> winningNumbers) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winningNumbers);
        if (nonDuplicateNumbers.size() != WINNING_NUMBERS_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    private void validateDuplicateBonus(List<Integer> winningNumbers, int bonusNumber) {
        boolean hasDuplicate = winningNumbers.stream()
                .anyMatch(number -> number == bonusNumber);
        if (hasDuplicate) {
            throw new IllegalArgumentException("당첨 번호에 보너스번호와 같은 번호가 있습니다.");
        }
    }


}
