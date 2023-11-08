package lotto;

import domain.ErrorMessage;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT_CNT.toString());
        }
        if (duplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_DUPLICATE.toString());
        }
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45 || number < 0)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.toString());
        }
    }


    public boolean duplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        return uniqueNumber.size() != numbers.size();
    }


    public List<Integer> getNumbers() {
        return numbers;
    }
}