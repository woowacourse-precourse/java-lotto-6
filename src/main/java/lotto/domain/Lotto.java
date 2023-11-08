package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = new ArrayList<>(this.numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers.toString();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
