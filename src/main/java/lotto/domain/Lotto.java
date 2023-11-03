package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        LottoValidator.validateNotDuplicate(numbers);
        validateInRangeEachNumber(numbers);
    }

    private void validateInRangeEachNumber(List<Integer> numbers) {
        numbers.stream()
                .forEach(LottoValidator::validateInRange);
    }

    public String getLottoNumber() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public Boolean hasSameNumber(int number) {
        return numbers.contains(number);
    }
}
