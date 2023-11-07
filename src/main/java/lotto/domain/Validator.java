package lotto.domain;

import static lotto.domain.Lotto.*;
import static lotto.error.ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.error.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.error.ErrorMessage.DUPLICATE_WINNING_NUMBER;
import static lotto.error.ErrorMessage.INVALID_WINNING_NUMBER_LENGTH;
import static lotto.error.ErrorMessage.NEGATIVE_PURCHASE_AMOUNT;
import static lotto.error.ErrorMessage.NOT_DIVIDED_PURCHASE_AMOUNT;
import static lotto.error.ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public void validatePurchaseAmount(Integer purchaseAmount) {
        validatePositiveNumber(purchaseAmount, NEGATIVE_PURCHASE_AMOUNT);
        validateDivided(purchaseAmount, NOT_DIVIDED_PURCHASE_AMOUNT);
    }


    private void validatePositiveNumber(Integer number, String error) {
        if (number <= 0) {
            throw new IllegalArgumentException(error);
        }
    }

    private void validateDivided(Integer number, String error) {
        if (number % PRICE != 0) {
            throw new IllegalArgumentException(error);
        }
    }

    public void validateWinningNumbers(List<Integer> winningNumbers) {
        validateLength(winningNumbers, INVALID_WINNING_NUMBER_LENGTH);
        for (Integer number : winningNumbers) {
            validateRange(number, WINNING_NUMBER_OUT_OF_RANGE);
        }
        validateDuplicate(winningNumbers, DUPLICATE_WINNING_NUMBER);
    }

    private void validateLength(List<Integer> winningNumbers, String error) {
        if (winningNumbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(error);
        }
    }

    private void validateRange(Integer number, String error) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(error);
        }
    }

    private void validateDuplicate(List<Integer> numbers, String error) {
        List<Integer> checkDuplicate = new ArrayList<>();
        for (Integer number : numbers) {
            if (checkDuplicate.contains(number)) {
                throw new IllegalArgumentException(error);
            }
            checkDuplicate.add(number);
        }
    }

    private void validateDuplicate(List<Integer> numbers, Integer number, String error) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(error);
        }
    }

    public void validateBonusNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        validateRange(bonusNumber, BONUS_NUMBER_OUT_OF_RANGE);
        validateDuplicate(winningNumbers, bonusNumber, DUPLICATE_BONUS_NUMBER);
    }
}
