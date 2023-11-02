package lotto;

import lotto.View.ExceptionView;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ExceptionView.sizeException();
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
