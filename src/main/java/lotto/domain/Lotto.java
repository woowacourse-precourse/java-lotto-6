package lotto.domain;

import java.util.List;

import static lotto.exception.ExceptionMessage.LottoException.LOTTO_SIZE_IS_NOT_FULFILL;

public class Lotto {
    private static final int TOTAL_SIZE = 6;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;

    private final List<Integer> numbers;

    private Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(final List<Integer> numbers) {
        validateLottoSize(numbers);
        return new Lotto(numbers);
    }

    private static void validateLottoSize(final List<Integer> numbers) {
        if (numbers.size() != TOTAL_SIZE) {
            throw new IllegalArgumentException(LOTTO_SIZE_IS_NOT_FULFILL.message);
        }
    }
}
