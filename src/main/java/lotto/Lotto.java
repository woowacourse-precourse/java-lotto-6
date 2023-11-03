package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        this.numbers = numbers;
    }


    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBERS_COUNT_ERROR.getMessage());
        }
    }

    private void duplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumber = new HashSet<>(numbers);
        if (uniqueNumber.size() < numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_VALUE_FOUND.getMessage());
        }
    }


}
