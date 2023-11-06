package lotto;

import java.util.List;

public class Lotto {
    public static final int MAX_NUMBER_OF_NUMBERS = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != MAX_NUMBER_OF_NUMBERS) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        long count = numbers.stream()
                .distinct()
                .count();
        if (count != MAX_NUMBER_OF_NUMBERS) throw new IllegalArgumentException();
    }

}
