package lotto.model;

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

        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int match(List<Integer> WinningNumbers) {
        return (int) WinningNumbers
                .stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean match(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
