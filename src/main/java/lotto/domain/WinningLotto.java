package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningLotto {

    private static final int WINNING_LOTTO_SIZE_CRITERION = 7;
    private List<Number> winningNumbers;
    private Number bonusNumber;

    public WinningLotto(List<Number> winningNumbers, Number bonusNumber) {
        validateNoDuplicatedWinningNumbers(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getMatchCount(List<Number> numbers) {
        return (int) numbers.stream()
            .filter(winningNumbers::contains)
            .count();
    }

    private void validateNoDuplicatedWinningNumbers(List<Number> winningNumbers,
        Number bonusNumber) {
        Set<Number> set = new HashSet<>(winningNumbers);
        set.add(bonusNumber);
        if (set.size() != WINNING_LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException();
        }
    }
}
