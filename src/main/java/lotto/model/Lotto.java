package lotto.model;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int LOTTO_LOWER_INCLUSIVE = 1;
    public static final int LOTTO_UPPER_INCLUSIVE = 45;
    public static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
    }


}
