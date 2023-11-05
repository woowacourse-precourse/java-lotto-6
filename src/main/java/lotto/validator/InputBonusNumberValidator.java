package lotto.validator;

import lotto.domain.LottoConstant;
import lotto.view.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class InputBonusNumberValidator {
    public void validate(String input) {
        validatePurchaseAmountIsBlank(input);
        validatePurchaseAmountIsNumeric(input);
        validatePurchaseAmountIsPositive(input);
        validateWinningLotteryNumbersIsBetweenValidRange(input);
    }

    public void validateBonusNumberIsDuplicatedWithWinningLotteryNumbers(String input, List<Integer> winningLotteryNumbers) {
        int number = Integer.parseInt(input);
        HashSet<Integer> set = new HashSet<>(winningLotteryNumbers);
        set.add(number);
        if (set.size() < 7) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_CANNOT_BE_DUPLICATED.getMessage());
        }
    }

    private void validatePurchaseAmountIsBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DOES_NOT_BLANK.getMessage());
        }
    }

    private void validatePurchaseAmountIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_NUMERIC.getMessage());
        }
    }

    private void validatePurchaseAmountIsPositive(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_POSITIVE.getMessage());
        }
    }

    private void validateWinningLotteryNumbersIsBetweenValidRange(String input) {
        int number = Integer.parseInt(input);
        if (number < LottoConstant.MIN_LOTTO_NUMBER.getValue() || number > LottoConstant.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
}
