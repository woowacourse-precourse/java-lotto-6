package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!checkSize(numbers) || !checkUnique(numbers) || !checkRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkSize(List<Integer> numbers) {
        return numbers.size() == 6;
    }

    private boolean checkUnique(List<Integer> numbers) {
        List<Integer> unique = numbers.stream().distinct().toList();
        return numbers.size() == unique.size();
    }

    private boolean checkRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 45);
    }

}
