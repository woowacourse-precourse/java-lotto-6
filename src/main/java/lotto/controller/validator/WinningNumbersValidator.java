package lotto.controller.validator;

import lotto.domain.DomainConstants;

import java.util.List;

public class WinningNumbersValidator {

    public void validateWinningNumbers(List<String> userInput) {
        validateNoBlank(userInput);
        validateOnlyNumbers(userInput);
        validateNumbersSizeSix(userInput);
        validateNumberRange(userInput);
        validateDuplicatedNumber(userInput);
    }

    private void validateNoBlank(List<String> userInput) {
        if (userInput.stream().anyMatch(num -> num.contains(DomainConstants.BLANK))) {
            throw new IllegalArgumentException(DomainConstants.NO_BLANK_MESSAGE);
        }
    }

    private void validateOnlyNumbers(List<String> userInput) {
        for (String num : userInput) {
            if(!(num.chars().allMatch(Character::isDigit))) {
                throw new IllegalArgumentException(DomainConstants.ONLY_NUMBERS_MESSAGE);
            }
        }
    }

    private void validateNumbersSizeSix(List<String> userInput) {
        if (userInput.size() != DomainConstants.LOTTO_NUMBERS) {
            throw new IllegalArgumentException(DomainConstants.SIX_NUMBERS_MESSAGE);
        }
    }

    private void validateNumberRange(List<String> userInput) {
        if (userInput.stream()
                .mapToInt(Integer::parseInt)
                .anyMatch(num -> num < DomainConstants.LOTTO_MIN_NUM || num > DomainConstants.LOTTO_MAX_NUM)) {
            throw new IllegalArgumentException(DomainConstants.NUMBER_RANGE_MESSAGE);
        }
    }

    private void validateDuplicatedNumber(List<String> userInput) {
        if (userInput.size() != userInput.stream().distinct().count()) {
            throw new IllegalArgumentException(DomainConstants.UNIQUE_SIX_NUMBERS_MESSAGE);
        }
    }
}