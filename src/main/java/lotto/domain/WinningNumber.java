package lotto.domain;

import static lotto.constant.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<String> numbersInput) {
        this.numbers = validateWinningNumber(numbersInput);
    }

    private List<Integer> validateWinningNumber(List<String> numbersInput) {
        validateSize(numbersInput);
        validateDuplicate(numbersInput);
        List<Integer> numbers = convertInteger(numbersInput);
        return numbers;
    }

    private List<Integer> convertInteger(List<String> numbersInput) {
        return numbersInput.stream()
                .map(this::validateNumeric)
                .toList();
    }

    private Integer validateNumeric(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NOT_NUMERIC.getMessage());
        }
    }

    private void validateDuplicate(List<String> numbersInput) {
        Set<String> uniqueNumbers = new HashSet<>(numbersInput);
        if (uniqueNumbers.size() != numbersInput.size()) {
            throw new IllegalArgumentException(NOT_UNIQUE.getMessage());
        }
    }

    private void validateSize(List<String> numbersInput) {
        if (numbersInput.size() != 6) {
            throw new IllegalArgumentException(NOT_LENGTH.getMessage());
        }
    }
}
