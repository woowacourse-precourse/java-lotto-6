package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .forEach((number, count) -> {
                    if (count > 1) {
                        throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getMessage());
                    }
                });
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
