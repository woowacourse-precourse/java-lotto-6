package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.policy.LottoPolicy;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        verifyNumberCount(numbers);
        verifyNumericRange(numbers);
        verifyDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void verifyNumberCount(List<Integer> numbers) {
        if (numbers.size() != LottoPolicy.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_COUNT.getMessage());
        }
    }

    private void verifyNumericRange(List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(value ->
                        (value < LottoPolicy.MIN_LOTTO_NUMBER.getValue())
                        || (value > LottoPolicy.MAX_LOTTO_NUMBER.getValue())
                )
        ) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private void verifyDuplicateNumber(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LottoPolicy.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}
