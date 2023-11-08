package lotto;

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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchNumbers(List<Integer> winningNumbers) {
        int matched = 0;
        for (int number : winningNumbers) {
            if (numbers.contains(number)) {
                matched++;
            }
        }
        return matched;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
