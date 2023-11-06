package lotto.domain;

import java.util.List;
import lotto.common.ErrorMessage;
import lotto.util.LottoNumberValidator;

public class Lotto {
    private static final Integer LOTTO_NUM_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from() {
        List<Integer> numbers = null;
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumSize(numbers);
        validateLottoInvalidNumber(numbers);
    }

    private void validateLottoNumSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUM_SIZE_ERROR.getMessage());
        }
    }

    private void validateLottoInvalidNumber(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> !LottoNumberValidator.validate(number))) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUM_RANGE_ERROR.getMessage());
        }
    }
}
