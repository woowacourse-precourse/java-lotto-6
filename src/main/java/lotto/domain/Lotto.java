package lotto.domain;

import java.util.List;

public class Lotto {

    private static final int NUMBER_SIZE = 6;

    private final List<Number> numbers;

    public Lotto(List<Integer> numbers) {
        List<Number> formattedNumbers = toNumberList(numbers);

        validate(formattedNumbers);
        this.numbers = formattedNumbers;
    }

    private List<Number> toNumberList(List<Integer> numbers) {
        return numbers.stream().map(Number::from).toList();
    }

    private void validate(List<Number> numbers) {
        validateSize(numbers);
    }

    private void validateSize(List<Number> numbers) {
        if (isDifferentFormat(numbers.size())) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDifferentFormat(int numberSize) {
        return numberSize != NUMBER_SIZE;
    }
}
