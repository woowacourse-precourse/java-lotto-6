package lotto.domain.validator;

import java.util.HashSet;
import java.util.List;

import java.util.Set;
import lotto.util.constants.ValidateConstants;


public class WinnerNumberValidator implements Validator<List<String>> {
    @Override
    public void validate(List<String> inputWinnerNumber) {
        validateNumeric(inputWinnerNumber);
        validateSize(inputWinnerNumber);
        validateDuplication(inputWinnerNumber);
        validateRange(inputWinnerNumber);
    }

    public void validateSize(List<String> winnerNumbers) {
        int size = ValidateConstants.WINNER_NUMBER_SIZE.getNumberConstants();
        if (winnerNumbers.size() != size) {
            throw new IllegalArgumentException(ValidateConstants.WINNER_NUMBER_SIZE_ERROR.getConstants());
        }
    }

    public void validateNumeric(List<String> winnerNumbers) {
        boolean invalidNumeric = winnerNumbers.stream()
                .anyMatch(string -> !string.matches(ValidateConstants.NUMERIC_REGEX.getConstants()));
        if (invalidNumeric) {
            throw new IllegalArgumentException(ValidateConstants.WINNER_NUMBER_NUMERIC_ERROR.getConstants());
        }
    }

    public void validateDuplication(List<String> winnerNumbers) {
        Set<String> numbersSet = new HashSet<>(winnerNumbers);
        if (winnerNumbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(ValidateConstants.WINNER_NUMBER_DUPLICATION_ERROR.getConstants());
        }
    }

    public void validateRange(List<String> winnerNumbers) {
        int min = ValidateConstants.LOTTO_MIN_NUMBER.getNumberConstants();
        int max = ValidateConstants.LOTTO_MAX_NUMBER.getNumberConstants();

        boolean isInvalidRange = winnerNumbers.stream()
                .anyMatch(number -> Integer.parseInt(number) < min || Integer.parseInt(number) > max);
        if (isInvalidRange) {
            throw new IllegalArgumentException(ValidateConstants.WINNER_NUMBER_RANGE_ERROR.getConstants());
        }
    }
}
