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
        validateDuplicate(numbersInput);
        return convertInteger(numbersInput);
    }

    private List<Integer> convertInteger(List<String> numbers) {
        return numbers.stream()
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

    private void validateDuplicate(List<String> numbers) {
        Set<String> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(NOT_UNIQUE.getMessage());
        }
    }
}
