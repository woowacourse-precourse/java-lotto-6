package lotto.model;

import java.util.List;

public record LottoNumber(List<Integer> numbers) {
    public int calculateMatchingCount(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream().filter(numbers::contains).count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int calculateMatchingCountWithWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        int matchingCount = calculateMatchingCount(winningNumbers);
        return (matchingCount == 5 && hasBonusNumber(bonusNumber)) ? 6 : matchingCount;
    }
}

