package lotto.domain;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidation(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateValidation(List<Integer> numbers) {
        Set<Integer> removeDuplicationNumber = new HashSet<>(numbers);
        if(removeDuplicationNumber.size() != numbers.size()){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
