package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        boolean isDuplicate = false;

        Predicate<Integer> checkDuplicate = new HashSet<>()::add;

        Integer duplicate = numbers.stream()
                .filter(checkDuplicate.negate())
                .findAny()
                .orElse(null);

        if (duplicate != null) {
            isDuplicate = true;
        }

        return isDuplicate;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}