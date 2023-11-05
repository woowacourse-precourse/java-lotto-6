package lotto.domain;

import java.util.List;

public class LottoWinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean hasWinningNumber(int number) {
        return this.winningNumbers.contains(number);
    }

    public int calculateWinningNumberCount(Lotto lotto) {
        return Math.toIntExact(
                this.winningNumbers.stream()
                        .filter(lotto::hasNumber)
                        .count()
        );
    }

    public boolean matchesBonusNumber(Lotto lotto) {
        return lotto.hasNumber(this.bonusNumber);
    }

}
