package lotto.validator;

import lotto.domain.LottoConstant;
import lotto.view.ErrorMessage;

import java.util.HashSet;
import java.util.List;

public class InputWinningLotteryNumberValidator {
    public void validate(String input) {
        validateWinningLotteryNumbersIsBlank(input);
        validateWinningLotteryNumbersIsNumeric(input);
        validateWinningLotteryNumbersIsPositive(input);
        validateWinningLotteryNumbersIsBetweenValidRange(input);
    }

    public void validateSizeAndDuplicatedNumbers(List<Integer> winningLotteryNumbers) {
        validateWinningLotteryNumbersSize(winningLotteryNumbers);
        validateWinningLotteryNumbersIsDuplicated(winningLotteryNumbers);
    }

    private void validateWinningLotteryNumbersIsBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_DOES_NOT_BLANK.getMessage());
        }
    }

    private void validateWinningLotteryNumbersIsNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_NUMERIC.getMessage());
        }
    }

    private void validateWinningLotteryNumbersIsPositive(String input) {
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

    private void validateWinningLotteryNumbersSize(List<Integer> winningLotteryNumbers) {
        if (winningLotteryNumbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.SIZE_OF_LOTTO_NUMBERS_LIST_MUST_BE_6.getMessage());
        }
    }

    private void validateWinningLotteryNumbersIsDuplicated(List<Integer> winningLotteryNumbers) {
        if (new HashSet<>(winningLotteryNumbers).size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_CANNOT_BE_DUPLICATED.getMessage());
        }
    }

}
