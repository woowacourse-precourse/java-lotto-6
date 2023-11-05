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

    private boolean checkInputSizeIs6(WinningNumbers winningNumbers) {
        return winningNumbers.getWinningNumbers().size() == 6;
    }

    private boolean checkInputBounds(WinningNumbers winningNumbers) {
        for (int number: winningNumbers.getWinningNumbers()) {
            if (!(1 <= number && number <= 45)){
                return false;
            }
        }
        return true;
    }
}
