package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isSixLength(numbers)) {
            throw new IllegalArgumentException();
        }

        if (isDuplicates(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isSixLength(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    public boolean isDuplicates(List<Integer> numbers) {
        return numbers.size() > numbers.stream().distinct().count();
    }

}
