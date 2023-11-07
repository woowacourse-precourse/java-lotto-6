package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        IsUnique(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void IsUnique(List<Integer> numbers) {
        numbers = numbers.stream().distinct().collect(Collectors.toList());
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getNumberIndex(int index) {
        return numbers.get(index);
    }

    public void setNumberIndex(int index, int value) {
        this.numbers.set(index, value);
    }
}
