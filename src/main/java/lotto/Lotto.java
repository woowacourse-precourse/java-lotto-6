package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        List<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException();
            }
            uniqueNumbers.add(number);
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
