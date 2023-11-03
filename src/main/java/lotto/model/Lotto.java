package lotto.model;

import java.util.List;
import lotto.util.Validation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validation.validateSixLottoNumbers(numbers);
        Validation.validateDuplicatedNumber(numbers);
    }

    // TODO: 추가 기능 구현
}
