package lotto.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        ArrayList<Integer> newNumbers = new ArrayList<>(numbers);
        newNumbers.sort(Comparator.naturalOrder());
        return newNumbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
