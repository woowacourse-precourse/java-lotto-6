package lotto.model.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        int MIN_NUMBER = 1;
        int MAX_NUMBER = 45;
        if (numbers.size() != 6 || numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().anyMatch(n -> n < MIN_NUMBER || n > MAX_NUMBER)){
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
