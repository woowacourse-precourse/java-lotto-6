package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

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
    }

    @Override
    public String toString() {
        String lottoPrintFormat = numbers.stream()
            .map(Object::toString)
            .collect(Collectors.joining(", "));
        return String.format("[%s]", lottoPrintFormat);
    }
}
