package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateValidate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateValidate(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);

        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getLottoNumber() {
        return this.numbers;
    }

}
