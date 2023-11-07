package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.model.Constants.DUPLICATE_LOTTO_NUMBERS;
import static lotto.model.Constants.INVALID_NUMBER_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBER_SIZE);
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        if(numSet.size()!= numbers.size()){
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBERS);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

