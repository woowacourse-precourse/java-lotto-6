package lotto;

import java.util.List;

import static lotto.LottoConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER.getValue() || n > MAX_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
