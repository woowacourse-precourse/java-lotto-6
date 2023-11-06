package lotto.input;

import java.util.List;
import java.util.Set;
import lotto.util.IntegerUtil;

public class InputValidator {
    public void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount < 1000 || purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (!IntegerUtil.checkNumberInRange(winningNumber, 1, 45)) {
                throw new IllegalArgumentException();
            }
        }
        checkWinningNumberIsDuplicate(winningNumbers);
    }

    private void checkWinningNumberIsDuplicate(List<Integer> winningNumbers) {
        if (Set.of(winningNumbers).size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateBonusNumber(Integer bonusNumber, List<Integer> winningNumbers) {
        if (!IntegerUtil.checkNumberInRange(bonusNumber, 1, 45)) {
            throw new IllegalArgumentException();
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }
}
