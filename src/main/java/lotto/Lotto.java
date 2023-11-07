package lotto;

import java.util.List;

public class Lotto {
    public static final Integer NUMBER_LENGTH = 6;
    public static final Integer NUMBER_MIN = 1;
    public static final Integer NUMBER_MAX = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer n : numbers) {
            if ((n < NUMBER_MIN) || (NUMBER_MAX < n)) {
                throw new IllegalArgumentException(String.format("로또 번호 %d가 주어진 범위를 벗어났습니다", n));
            }
        }
    }
}
