package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    @Override
    public String toString() {
        return numbers.toString();
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int checkNumber(List<Integer> numbers) {
        int number = (int) numbers.stream()
                .filter(this.numbers::contains)
                .count();

        return number;
    }
}
