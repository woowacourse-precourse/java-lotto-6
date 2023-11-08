package lotto;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

public class Lotto {
    private final static Integer LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        sortNumbers();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void sortNumbers() {
        Collections.sort(this.numbers);
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }
}
