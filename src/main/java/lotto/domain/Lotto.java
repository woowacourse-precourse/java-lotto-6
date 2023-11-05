package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.validation.LottoValidationHandler;

public class Lotto {
    private static final String DELIMITER = ", ";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidationHandler.validationNumbersSize(numbers);
        LottoValidationHandler.validationNumbersRange(numbers);
        LottoValidationHandler.validateDuplicatedNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .sorted()
                .map(Objects::toString)
                .collect(Collectors.joining(DELIMITER));
    }
}
