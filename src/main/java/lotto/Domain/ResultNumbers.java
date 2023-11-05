package lotto.Domain;

import lotto.Validator.Validator;

import java.util.List;

public class ResultNumbers {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public ResultNumbers(List<Integer> winningNumbers, int bonusNumber) {
        Validator.valiateDuplicateNums(winningNumbers);
        Validator.validateSize(winningNumbers);
        Validator.validateNumbersRange(winningNumbers);
        Validator.validateNumberRange(bonusNumber);
        Validator.validateContainWinningNumbers(winningNumbers, bonusNumber);
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
