package lotto;

import util.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private final Validator validator = new Validator();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        validator.checkLottoInput(numbers.toString());
    }

    // TODO: 추가 기능 구현
}
