package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final String INVALID_LOTTO_SIZE_MESSAGE = "당첨 번호는 숫자 " + LOTTO_SIZE + "개를 입력해야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_RANGE_MESSAGE =
            "당첨 번호를 " + MIN_LOTTO_NUMBER + " ~ " + MAX_LOTTO_NUMBER + " 사이의 숫자로 입력해주세요.";
    public static final String DUPLICATE_NUMBERS_MESSAGE = "당첨 번호를 중복되지 않은 숫자로 입력해주세요.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbersInLottoRange(numbers);
        validateDuplicateNumbers(numbers);
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

    private void validateDuplicateNumbers(final List<Integer> numbers) {
        for (Integer number : numbers) {
            long count = numbers.stream()
                    .filter(num -> num.equals(number))
                    .count();

            if (count > 1) {
                throw new IllegalArgumentException(DUPLICATE_NUMBERS_MESSAGE);
            }
        }
    }
}
