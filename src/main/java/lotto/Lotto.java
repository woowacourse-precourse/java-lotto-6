package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        hasDuplicateNumber(numbers);
    }
    private void hasDuplicateNumber(List<Integer> numbers) {
        final Set<Integer> set = new HashSet<>();

        for (Integer yourInt : numbers) {
            if (!set.add(yourInt)) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
}
