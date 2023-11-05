package lotto.Domain;

import lotto.Validator.Validator;

import java.util.List;

public class ResultNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public ResultNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
