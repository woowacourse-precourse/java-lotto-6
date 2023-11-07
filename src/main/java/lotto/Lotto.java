package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        duplicate();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicate() {
        boolean hasDuplicates = numbers.stream()
                .distinct()
                .count() < numbers.size();
        if (hasDuplicates) {
            throw new IllegalArgumentException("[ERROR] : 중복된 숫자가 존재합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}