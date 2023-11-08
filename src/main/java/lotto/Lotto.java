package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    private final int LOTTO_NUMBER_SIZE = 6;
    ErrorMessages errorType;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);

        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            errorType = ErrorMessages.NUMBER_INCORRECT_SIZE;
            throw new IllegalArgumentException(errorType.getDescription());
        }

        if (numbers.size() != numbersSet.size()) {
            errorType = ErrorMessages.NUMBER_DUPLICATED;
            throw new IllegalArgumentException(errorType.getDescription());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getWinningCount(List<Integer> winningNumber) {
        List<Integer> matchedNumbers = new ArrayList<>(winningNumber);

        matchedNumbers.retainAll(numbers);
        return matchedNumbers.size();
    }
}
