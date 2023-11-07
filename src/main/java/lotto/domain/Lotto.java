package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public int size() {
        return numbers.size();
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public boolean contains(int value) {
        return numbers.contains(value);
    }
}
