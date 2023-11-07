package domain;

import utils.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.checkLottoSizeNumberInput(numbers);
        Validator.checkLottoDuplicatedNumberInput(numbers);
    }

    // TODO: 추가 기능 구현
}
