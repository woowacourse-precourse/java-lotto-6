package lotto.domain;

import java.util.List;
import lotto.validator.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.hasDuplicateNumbers(numbers);
        LottoNumberValidator.validateLottoNumbersRange(numbers);
    }

    // TODO: 추가 기능 구현
}
