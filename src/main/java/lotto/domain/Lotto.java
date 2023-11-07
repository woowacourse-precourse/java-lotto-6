package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

record Lotto(List<Integer> numbers) {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    Lotto {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < MIN_RANGE || number > MAX_RANGE) {
                throw new IllegalArgumentException();
            }
        }
    }

    boolean contains(int number) {
        return numbers.contains(number);
    }

    public int countMatchedNumber(Lotto values) {
        List<Integer> target = new ArrayList<>(numbers);
        target.retainAll(values.numbers);
        return target.size();
    }
}
