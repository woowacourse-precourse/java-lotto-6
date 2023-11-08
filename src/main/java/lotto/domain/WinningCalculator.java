package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validator.Errors;
import lotto.view.Output;

public class WinningCalculator {

    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public WinningCalculator(List<Integer> winningNumbers, Integer bonusNumber) {
        validateDuplicateNumber(winningNumbers, bonusNumber);
        validateNumberCount(winningNumbers);
        validateNumberInRange(winningNumbers);
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

    private void validateNumberInRange(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > Lotto.LOTTO_NUMBER_END || numbers.get(i) < Lotto.LOTTO_NUMBER_START) {
                Output.printErrorMessage(Errors.NOT_IN_RANGE.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != Lotto.LOTTO_NUMBER_COUNT) {
            Output.printErrorMessage(Errors.NEED_MORE_INPUT.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers, Integer bonusNumber) {
        Set<Integer> set = new HashSet<>(numbers);
        set.add(bonusNumber);
        if (set.size() != numbers.size() + 1) {
            Output.printErrorMessage(Errors.DUPLICATE_NUMBER.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
