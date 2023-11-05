package lotto.domain;

import java.util.List;

public class WinningLotto {

    private List<Integer> winningNumbers;
    private BonusNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        validateNoDuplicatedWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(List<Integer> numbers) {
        return (int) numbers.stream()
            .filter(winningNumbers::contains)
            .count();
    }

    public boolean isBonusMatched(List<Integer> numbers) {
        return bonusNumber.isIn(numbers);
    }

    private void validateNoDuplicatedWinningNumbers(List<Integer> winningNumbers,
        BonusNumber bonusNumber) {
        if (bonusNumber.isIn(winningNumbers)) {
            throw new IllegalArgumentException();
        }
    }
}
