package lotto.domain;

import java.util.List;

public class Lotto {
    public static final Integer NUMBER_LENGTH = 6;
    public static final Integer MIN = 1;
    public static final Integer MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
