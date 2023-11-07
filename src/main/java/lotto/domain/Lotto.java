package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER = 6;
    public static final int LOTTO_RANGE_BEGIN = 1;
    public static final int LOTTO_RANGE_END = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
