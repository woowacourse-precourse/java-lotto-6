package lotto;

import java.util.List;

public class Lotto {
    public static final int MIN_BOUND = 1;
    public static final int MAX_BOUND = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValid(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isValid(List<Integer> numbers) {
        return hasProperLength(numbers) && hasProperRange(numbers) && hasDistinctNumbers(numbers);
    }

    private boolean hasProperLength(List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBERS_SIZE;
    }

    private boolean hasProperRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= MIN_BOUND && number <= MAX_BOUND);
    }

    private boolean hasDistinctNumbers(List<Integer> numbers) {
        return numbers.stream().distinct().count() == 6;
    }
}
