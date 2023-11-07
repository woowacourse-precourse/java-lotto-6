package lotto.utils;

import lotto.view.ExceptionMessage;

import java.util.*;

public class PrizeNumberValidator {
    private final List<Integer> numbers = new ArrayList<>();
    private final int bonusNumber;

    public PrizeNumberValidator(List<Integer> winNumber, int bonusNumber) {
        validateDuplicatedWinningNumber(winNumber);
        validateDuplicatedBonusNumber(winNumber, bonusNumber);
        validateSixWinningNumbers(winNumber);
        validateBonusNumberRange(bonusNumber);
        validateWinningNumberRange(winNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicatedWinningNumber(List<Integer> winNumber) {
        Set<Integer> duplicatedCheck = new HashSet<>(winNumber);
        if (duplicatedCheck.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_DUPLICATED_ERROR);
        }
    }

    private void validateDuplicatedBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_DUPLICATED_ERROR);
        }
    }

    private void validateSixWinningNumbers(List<Integer> winNumber) {

        if (winNumber.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.PRIZE_NUMBER_FORMAT_ERROR);
        }
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NUMBER_RANGE_ERROR);
        }
    }

    private void validateWinningNumberRange(List<Integer> numbers) {
        for(Integer number : numbers) {
            if(number < 1 || number > 45) {
                throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_RANGE_ERROR);
            }
        }
    }
}