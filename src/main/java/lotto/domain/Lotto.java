package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_PRICE_UNIT = 1000;
    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBERS_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException();
        }
    }

}
