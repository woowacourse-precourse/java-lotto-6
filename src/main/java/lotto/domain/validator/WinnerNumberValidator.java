package lotto.domain.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import lotto.util.constants.ValidateConstants;


public class WinnerNumberValidator implements Validator<List<String>> {
    @Override
    public boolean inputValidate(List<String> inputWinnerNumber) {
        try {
            validateNumeric(inputWinnerNumber);
            validateRange(inputWinnerNumber);
            validateDuplication(inputWinnerNumber);
            validateSize(inputWinnerNumber);
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    public void validateSize(List<String> winnerNumbers) {
        int size = ValidateConstants.WINNER_NUMBER_SIZE.getNumberConstants();
        if (winnerNumbers.size() != size) {
            throw new IllegalArgumentException(ValidateConstants.WINNER_NUMBER_SIZE_ERROR.getConstants());
        }
    }

    public void validateNumeric(List<String> winnerNumbers) {
        Optional<String> invalidNumber = winnerNumbers.stream()
                .filter(string -> !string.matches(ValidateConstants.NUMERIC_REGEX.getConstants()))
                .findAny();

        if (invalidNumber.isPresent()) {
            throw new IllegalArgumentException(ValidateConstants.WINNER_NUMBER_NUMERIC_ERROR.getConstants());
        }
    }

    public void validateRange(List<String> winnerNumbers) {
        int min = ValidateConstants.WINNER_MIN_NUMBER.getNumberConstants();
        int max = ValidateConstants.WINNER_MAX_NUMBER.getNumberConstants();

        Optional<String> invalidNumber = winnerNumbers.stream()
                .filter(string -> (Integer.parseInt(string) < min || Integer.parseInt(string)>max))
                .findAny();

        if (invalidNumber.isPresent()) {
            throw new IllegalArgumentException(ValidateConstants.WINNER_NUMBER_RANGE_ERROR.getConstants());
        }
    }

    public void validateDuplication(List<String> winnerNumbers) {
        Set<String> numbersSet = new HashSet<>(winnerNumbers);
        if (winnerNumbers.size() != numbersSet.size()) {
            throw new IllegalArgumentException(ValidateConstants.WINNER_NUMBER_DUPLICATION_ERROR.getConstants());
        }
    }

}
