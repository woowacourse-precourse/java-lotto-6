package lotto.Domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Exception.WinningNumberErrorMessage;

public class Lotto {
    private final int REFERENCE_VALUE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != REFERENCE_VALUE) {
            throw new IllegalArgumentException(WinningNumberErrorMessage.TOO_MANY_WINNING_NUMBERS.getMessage());
        }

        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(WinningNumberErrorMessage.DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }

    private boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.add(number)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
