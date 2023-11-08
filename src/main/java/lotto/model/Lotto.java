package lotto.model;

import java.util.List;
import lotto.controller.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation validation = new Validation();

        validation.lottoNumberCount(numbers);
        validation.rangeOfLottoNumber(numbers);
        validation.duplicateNumber(numbers);
    }

    // TODO: 추가 기능 구현
}
