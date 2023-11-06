package lotto.input;

import java.util.List;
import java.util.Set;

public class InputValidator {
    public void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            checkWinningNumberRange(winningNumber);
        }
        checkWinningNumberIsDuplicate(winningNumbers);
    }

    private void checkWinningNumberRange(Integer winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    private void checkWinningNumberIsDuplicate(List<Integer> winningNumbers) {
        if (Set.of(winningNumbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
