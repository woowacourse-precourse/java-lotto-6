package lotto.utils;

import lotto.view.ExceptionMessage;

import java.util.*;

public class PrizeNumberValidator {
    private final List<Integer> numbers = new ArrayList<>();
    private final int bonusNumber;

    public PrizeNumberValidator(List<Integer> winNumber, int bonusNumber) {
        validateSixNumbers(winNumber);
        validateNumberRange(bonusNumber);
        validateBonusNumber(winNumber, bonusNumber);
        validateRange(winNumber);
        validateDuplicatedNumber(winNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicatedNumber(List<Integer> winNumber) {
        Set<Integer> duplicatedCheck = new HashSet<>(winNumber);
        if (duplicatedCheck.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_DUPLICATED_ERROR);
        }
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_NUMBER_DUPLICATED_ERROR);
        }
    }
}