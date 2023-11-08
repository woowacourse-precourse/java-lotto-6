package lotto.domain;

import static lotto.domain.Lotto.*;
import static lotto.error.ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.error.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.error.ErrorMessage.DUPLICATE_WINNING_NUMBER;
import static lotto.error.ErrorMessage.INVALID_BONUS_NUMBER_FORMAT;
import static lotto.error.ErrorMessage.INVALID_PURCHASE_AMOUNT_FORMAT;
import static lotto.error.ErrorMessage.INVALID_WINNING_NUMBER_FORMAT;
import static lotto.error.ErrorMessage.INVALID_WINNING_NUMBER_LENGTH;
import static lotto.error.ErrorMessage.NEGATIVE_PURCHASE_AMOUNT;
import static lotto.error.ErrorMessage.NOT_DIVIDED_PURCHASE_AMOUNT;
import static lotto.error.ErrorMessage.WINNING_NUMBER_OUT_OF_RANGE;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static final String REGEX = ",";

    public Integer validatePurchaseAmount(String input) {
        Integer purchaseAmount = validateFormatAndConvert(input, INVALID_PURCHASE_AMOUNT_FORMAT);
        validatePositiveNumber(purchaseAmount, NEGATIVE_PURCHASE_AMOUNT);
        validateDivided(purchaseAmount, NOT_DIVIDED_PURCHASE_AMOUNT);
        return purchaseAmount;
    }

    private static Integer validateFormatAndConvert(String input, String error) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(error);
        }
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

    public List<Integer> validateWinningNumbers(String input) {
        List<Integer> winningNumbers = validateFormatAndConvert(input.split(REGEX), INVALID_WINNING_NUMBER_FORMAT);
        validateLength(winningNumbers, INVALID_WINNING_NUMBER_LENGTH);
        for (Integer number : winningNumbers) {
            validateRange(number, WINNING_NUMBER_OUT_OF_RANGE);
        }
        validateDuplicate(winningNumbers, DUPLICATE_WINNING_NUMBER);
        return winningNumbers;
    }

    private static List<Integer> validateFormatAndConvert(String[] input, String error) {
        List<Integer> result = new ArrayList<>();
        try {
            for (int index = 0; index < input.length; index++) {
                int converted = Integer.parseInt(input[index]);
                result.add(converted);
            }
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(error);
        }
        return result;
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

    public Integer validateBonusNumber(List<Integer> winningNumbers, String input) {
        Integer bonusNumber = validateFormatAndConvert(input, INVALID_BONUS_NUMBER_FORMAT);
        validateRange(bonusNumber, BONUS_NUMBER_OUT_OF_RANGE);
        validateDuplicate(winningNumbers, bonusNumber, DUPLICATE_BONUS_NUMBER);
        return bonusNumber;
    }
}
