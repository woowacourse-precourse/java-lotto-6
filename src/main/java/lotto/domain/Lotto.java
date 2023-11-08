package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현


    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
