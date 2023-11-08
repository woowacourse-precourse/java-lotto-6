package lotto;

import lotto.utils.Error;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException(Error.INVALID_WINNING_NUMBER.getMessage());
        }
        if (!hasUniqueNumbers(numbers)) {
            throw new IllegalArgumentException(Error.DUPLICATED_WINNING_NUMBER.getMessage());
        }
        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException(Error.INVALID_WINNING_NUMBER.getMessage());
        }
    }
    private boolean hasUniqueNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() == numbers.size();
    }
    public List<Integer> getNumbers(){
        return numbers;
    }

}
