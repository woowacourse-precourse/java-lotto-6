package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final String INVALID_LOTTO_SIZE_MESSAGE = "당첨 번호는 숫자 " + LOTTO_SIZE + "개를 입력해야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE_MESSAGE =
            "당첨 번호를 " + MIN_LOTTO_NUMBER + " ~ " + MAX_LOTTO_NUMBER + " 사이의 숫자로 입력해주세요.";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbersInLottoRange(numbers);
    }

    private void validateNumberSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE_MESSAGE);
        }
    }

    private void validateNumbersInLottoRange(final List<Integer> numbers) {
        boolean anyMatch = numbers.stream().anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER);

        if (anyMatch) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE_MESSAGE);
        }
    }
}
