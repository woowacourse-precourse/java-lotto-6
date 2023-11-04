package lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        HashSet<Integer> numbersWithoutDuplication = new HashSet<>(numbers);
        return numbersWithoutDuplication.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
