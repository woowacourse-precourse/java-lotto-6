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
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidRange(List<Integer> numbers) {
        for(int number : numbers) {
            if(number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
}
