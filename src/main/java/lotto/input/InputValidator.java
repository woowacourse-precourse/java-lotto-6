package lotto.input;

import static lotto.error.message.InvalidInputErrorMessage.*;

import java.util.List;
import java.util.Set;
import lotto.error.exception.InvalidInputException;
import lotto.util.IntegerUtil;

public class InputValidator {
    public void validatePurchaseAmount(Integer purchaseAmount) {
        if (purchaseAmount < 1000) {
            throw new InvalidInputException(PURCHASE_AMOUNT_UNDER_THOUSAND.getMessage(), purchaseAmount);
        }
        if (purchaseAmount % 1000 != 0) {
            throw new InvalidInputException(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND.getMessage(), purchaseAmount);
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        for (Integer winningNumber : winningNumbers) {
            if (!IntegerUtil.checkNumberInRange(winningNumber, 1, 45)) {
                throw new InvalidInputException(OUT_OF_RANGE.getMessage(), winningNumber);
            }
        }
        checkWinningNumberIsDuplicate(winningNumbers);
    }

    private void checkWinningNumberIsDuplicate(List<Integer> winningNumbers) {
        if (Set.of(winningNumbers).size() != 6) {
            throw new InvalidInputException(WINNING_NUMBERS_DUPLICATE.getMessage(), winningNumbers.toString());
        }
    }

    public void validateBonusNumber(Integer bonusNumber, List<Integer> winningNumbers) {
        if (!IntegerUtil.checkNumberInRange(bonusNumber, 1, 45)) {
            throw new InvalidInputException(OUT_OF_RANGE.getMessage(), bonusNumber);
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new InvalidInputException(BONUS_NUMBER_IN_WINNING_NUMBER.getMessage(), bonusNumber);
        }
    }
}
