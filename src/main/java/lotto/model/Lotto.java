package lotto.model;

import java.util.Collections;
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

        for (int number : numbers) {
            if (!isValidRange(number)) {
                throw new IllegalArgumentException();
            }

            if (isNumberDuplicated(number, numbers)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public boolean isValidRange(int number) {
        if (number < 1 || number > 45) {
            return false;
        }
        return true;
    }

    public boolean isNumberDuplicated(int number, List<Integer> numbers) {
        return Collections.frequency(numbers, number) > 1;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
