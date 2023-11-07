package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Lotto {

    public static final int DEFAULT_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNotDuplicated(numbers);
    }

    private static void validateNumberSize(List<Integer> numbers) {
        if (numbers.size() != DEFAULT_NUMBER_SIZE) {
            throw new IllegalArgumentException("Size of lotto number should be %d.".formatted(DEFAULT_NUMBER_SIZE));
        }
    }

    private void validateNotDuplicated(List<Integer> numbers) {
        if (duplicatedNumberExists(numbers)) {
            throw new IllegalArgumentException(
                    "Some elements of %s are duplicated.".formatted(Arrays.toString(numbers.toArray()))
            );
        }
    }

    private boolean duplicatedNumberExists(List<Integer> numbers) {
        return numbers.size() != Set.copyOf(numbers).size();
    }

    public int getNumbersSize() {
        return this.numbers.size();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(this.numbers);
    }

    public boolean hasNumber(int number) {
        return this.numbers.contains(number);
    }

}
