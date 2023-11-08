package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6 || !areAllNumbersUnique(numbers) || !areNumbersInRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현

    private boolean areAllNumbersUnique(List<Integer> numbers) {
        return numbers.stream().distinct().count() == numbers.size();
    }
    private boolean areNumbersInRange(List<Integer> numbers) {
        return numbers.stream().allMatch(n -> n >= 1 && n <= 45);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
