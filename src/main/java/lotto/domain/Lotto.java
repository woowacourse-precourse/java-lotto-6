package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchedNumberCount(Lotto lotto2) {
        return numbers.stream()
                .filter(now -> lotto2.getNumbers()
                        .stream()
                        .anyMatch(Predicate.isEqual(now)))
                .toList().size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
