package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public Lotto(List<Integer> numbers, Integer bonusNumber) {
        validate(numbers);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
