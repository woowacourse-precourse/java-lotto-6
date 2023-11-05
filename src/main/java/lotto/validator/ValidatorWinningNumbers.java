package lotto.validator;

import java.util.HashSet;
import java.util.Set;
import lotto.model.WinningNumbers;

public class ValidatorWinningNumbers {
    public ValidatorWinningNumbers() {
    }

    private boolean checkForDuplicates(WinningNumbers winningNumbers) {
        Set<Integer> numbers = new HashSet<>(winningNumbers.getWinningNumbers());
        return numbers.size() == winningNumbers.getWinningNumbers().size();
    }
}
