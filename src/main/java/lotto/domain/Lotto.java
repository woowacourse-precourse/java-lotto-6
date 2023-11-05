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
        if (!LottoNumberValidator.hasDuplicateNumbers(numbers) && !LottoNumberValidator.validateLottoNumbersRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
