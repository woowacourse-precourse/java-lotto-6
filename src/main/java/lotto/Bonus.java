package lotto;

import java.util.List;

public class Bonus {
    private final int number;

    public Bonus(int number, List<Integer> numbers) {
        validate(number, numbers);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(int number, List<Integer> numbers) {
        validateRange(number, MIN_NUMBER, MAX_NUMBER);
        validateDuplicates(number, numbers);
    }

    private void validateRange(int number, int minNumber, int maxNumber) {
        if (!(number >= minNumber && number <= maxNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicates(int number, List<Integer> numbers) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }
}
