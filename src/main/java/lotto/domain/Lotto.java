package lotto.domain;

import lotto.constants.Value;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }


    public Lotto(List<Integer> numbers) {
        validate(numbers);
        uniqueValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void uniqueValidate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }


    // TODO: 추가 기능 구현

    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}
