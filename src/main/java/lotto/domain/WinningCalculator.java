package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningCalculator {

    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public WinningCalculator(List<Integer> winningNumbers, Integer bonusNumber) {
        validateDuplicateNumber(winningNumbers, bonusNumber);
        validateNumberCount(winningNumbers);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult calculate(List<Lotto> lottoes) {
        WinningResult winningResult = new WinningResult();
        for (Lotto lotto : lottoes) {
            int numberOfMatches = lotto.getNumberOfMatches(winningNumbers);
            winningResult.addResults(numberOfMatches, lotto.containsBonusNumber(bonusNumber));
        }
        return winningResult;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != Lotto.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers, Integer bonusNumber) {
        Set<Integer> set = new HashSet<>(numbers);
        set.add(bonusNumber);
        if (set.size() != numbers.size() + 1) {
            throw new IllegalArgumentException();
        }
    }
}
