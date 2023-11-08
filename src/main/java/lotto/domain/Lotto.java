package lotto.domain;

import lotto.Validator.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    private void validate(List<Integer> numbers) {
        Validator validator= new Validator();
        validator.validateLottoNumber(numbers);
    }

    // TODO: 추가 기능 구현
}
