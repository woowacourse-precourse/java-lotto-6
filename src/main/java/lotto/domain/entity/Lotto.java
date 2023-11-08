package lotto.domain.entity;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoGenerator.COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public int calculateCountOfNumberEqualToWinningNumber(final Lotto other) {
        return (int) this.numbers
                .stream()
                .filter(other::contain)
                .count();
    }

    public boolean contain(final int number) {
        return this.numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
