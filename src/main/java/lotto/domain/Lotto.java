package lotto.domain;

import lotto.view.InputView;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateNumbers(numbers);
        checkRangeOneToFortyFive(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void duplicateNumbers(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();

        if (distinctCount != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkRangeOneToFortyFive(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
