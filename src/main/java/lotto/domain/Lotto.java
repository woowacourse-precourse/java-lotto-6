package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if ( !(isDuplicated(numbers) && numbers.size() == 6)) {
            throw new IllegalArgumentException();
        }
    }
    private boolean isDuplicated(List<Integer> numbers) {
        int size = numbers.size();
        return size == numbers.stream().distinct().count();
    }


}
