package lotto.Domain;

import lotto.Validator.Validator;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    public WinningNumbers(List<Integer> winningNumbers) {
        Validator.valiateDuplicateNums(winningNumbers);
        Validator.validateSize(winningNumbers);
        Validator.validateNumbersRange(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }
}
