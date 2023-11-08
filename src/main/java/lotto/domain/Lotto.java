package lotto.domain;

import java.util.List;
import static lotto.validator.LottoNumberValidator.validate_MIN_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validate_MIN_SIZE(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    // TODO: 추가 기능 구현
}
