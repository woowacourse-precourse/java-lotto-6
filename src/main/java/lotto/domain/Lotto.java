package lotto.domain;

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
        if (numbers.size() != LottoConfiguration.NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }

        Set<Integer> hashSet = new HashSet<>(numbers);
        if (hashSet.size() != LottoConfiguration.NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
