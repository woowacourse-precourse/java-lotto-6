package lotto.domain;

import lotto.validation.DomainValidate;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        DomainValidate.validateNumberInRange(numbers.size());
        DomainValidate.validateNumberOfLottoNumbers(numbers);
        DomainValidate.validateDuplicated(numbers);
    }
}
