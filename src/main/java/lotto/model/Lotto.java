package lotto.model;

import java.util.List;
import lotto.validator.LottoNumbersValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumbersValidator validator = new LottoNumbersValidator();
        validator.validate(numbers);
    }

    // TODO: 추가 기능 구현
}
