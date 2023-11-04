package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private static final String SPLIT_CHAR = ", ";

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
    public String toString(){
        return numbers.stream()
                .sorted().map(Objects::toString)
                .collect(Collectors.joining(SPLIT_CHAR));
    }
}
