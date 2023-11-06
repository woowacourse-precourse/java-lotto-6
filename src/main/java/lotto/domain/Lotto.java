package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static final int TARGET_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != TARGET_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getUserNumbers(){
        return numbers;
    }
}
