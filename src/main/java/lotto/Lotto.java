package lotto;

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

        if (numbers.stream().count() > 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> get_lotto_numbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
