package lotto.data;

import lotto.error.Error;

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

    public void print() {
        System.out.println(numbers.toString());
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_SIZE_ERROR.getMessage());
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(Error.LOTTO_DUPLICATE_ERROR.getMessage());
        }
    }
}
