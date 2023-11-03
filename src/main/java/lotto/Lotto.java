package lotto;

import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int NUMBERS_SIZE = 6;
    private final List<Integer> numbers;


    public Lotto(List<Integer> numbers) {

        validateSize(numbers);
        validateDuplication(numbers);

        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {

        Set<Integer> testNumbers = Set.copyOf(numbers);

        if(testNumbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

}
