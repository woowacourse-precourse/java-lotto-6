package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int LOTTO_NUMBER_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
