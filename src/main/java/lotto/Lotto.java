package lotto;

import java.util.List;

public class Lotto {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String INVALID_NUMBER_COUNT = "로또 숫자 개수에 맞도록 입력해주세요.";
    private static final String INVALID_NUMBER_RANGE = "로또 숫자 범위에 맞도록 입력해주세요.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT);
        }

        if (numbers.stream().anyMatch(
                number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER)
        ) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    // TODO: 추가 기능 구현
}
