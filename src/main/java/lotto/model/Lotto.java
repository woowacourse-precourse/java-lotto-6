package lotto.model;

import lotto.validation.Validator;
import java.util.List;

public class Lotto {
    private static final String LOTTO_NUMBER = "로또";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.validateDuplicateNumber(numbers, LOTTO_NUMBER);
        Validator.validateNumberInRange(numbers, LOTTO_NUMBER);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
