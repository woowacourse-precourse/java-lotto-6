package lotto.model;

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
        if (numbers.size() != 6 || isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                return true;
            }
        }
        return false;
    }

    // TODO: 추가 기능 구현
}
