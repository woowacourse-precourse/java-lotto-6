package lotto.domain;

import java.util.ArrayList;
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
        validateCount(numbers);
        validateNumberRange(numbers);
        validateNoDuplicates(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (int i : numbers) {
            if (!WinningLotto.isInRange(i)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Integer> cloneNumbers() {
        return new ArrayList<>(numbers);
    }


}
