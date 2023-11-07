package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> duplicateChecker = new HashSet<>(numbers);
        if (duplicateChecker.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int countMatch(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::containNumber)
                .count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }
}
