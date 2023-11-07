package lotto.domain;

import java.util.List;
import java.util.stream.Stream;
import lotto.validator.Validator;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator.validateNumberCount(numbers);
        Validator.validateNumberRange(numbers);
        Validator.validateDuplicateNumber(numbers);
    }

    public Stream<Integer> getStream() {
        return numbers.stream();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
