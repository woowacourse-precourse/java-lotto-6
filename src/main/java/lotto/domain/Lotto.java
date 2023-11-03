package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final String INVALID_LOTTO_SIZE_MESSAGE = "당첨 번호는 숫자 " + LOTTO_SIZE + "개를 입력해야 합니다.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateNumberSize(numbers);
    }

    private void validateNumberSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MESSAGE);
        }
    }
}
