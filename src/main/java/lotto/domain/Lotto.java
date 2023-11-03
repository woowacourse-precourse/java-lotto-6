package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);

        this.numbers = numbers;
    }

    public long countingMatchNumbers(Lotto lotto) {
        return this.numbers.stream()
                .filter(number -> lotto.containsNumber(number))
                .count();
    }

    public boolean containsNumber(int number) {
        return numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        long count = numbers.stream().distinct().count();

        if (numbers.size() != count) {
            throw new IllegalArgumentException();
        }
    }

}
