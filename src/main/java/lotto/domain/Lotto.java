package lotto.domain;

import lotto.utils.ErrorMessage;

import java.util.ArrayList;
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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SIX_NUMBER.errorMessage);
        }

        Set<Integer> noDuplicateNumber = new HashSet<>(numbers);
        if (noDuplicateNumber.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.errorMessage);
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(this.numbers);
    }
}
