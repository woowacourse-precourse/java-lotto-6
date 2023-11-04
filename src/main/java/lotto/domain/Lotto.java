package lotto.domain;

import java.util.List;
import lotto.domain.wrapper.LottoNumber;
import lotto.utils.ErrorMessage;

public class Lotto {
    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(
                    ErrorMessage.LOTTO_NUMBERS_LENGTH_ERROR.getFormattedMessage(LOTTO_NUMBERS_LENGTH));
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        long uniqueNumbersLength = numbers.stream()
                .distinct()
                .count();
        if (numbers.size() != uniqueNumbersLength) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_DUPLICATION_ERROR.getMessage());
        }
    }
}
