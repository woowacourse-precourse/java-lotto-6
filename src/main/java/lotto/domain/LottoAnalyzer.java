package lotto.domain;

import lotto.util.ExceptionMessage;

import java.util.List;

public class LottoAnalyzer {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoAnalyzer(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = isValidBonus(bonusNumber);
    }

    private int isValidBonus(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_WINNING_NUMBER);
        }
        return bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
