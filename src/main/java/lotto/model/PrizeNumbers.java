package lotto.model;

import java.util.Set;

public class PrizeNumbers {
    private Set<Integer> winningNumbers;
    private int bonusNumber;

    public PrizeNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isMatched(int lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean isBonusNumber(int lottoNumber) {
        return bonusNumber == lottoNumber;
    }
}
