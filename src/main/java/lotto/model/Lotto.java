package lotto.model;

import static lotto.model.LottoConstant.LOTTO_NUMBERS_SIZE;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
