package lotto;

import java.util.List;

public class Lotto {
    public static final Integer NUMBER_LENGTH = 6;
    public static final Integer NUMBER_MIN = 1;
    public static final Integer NUMBER_MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
