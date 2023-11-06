package lotto.domain;

import lotto.exception.ExceptionMessage;

import java.util.List;

public class Lotto {
    private static final int LOTTO_COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateDuplicate(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_COUNT.get(LOTTO_COUNT));
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();

        if(numbers.size() != distinctCount) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATED_LOTTO_NUMBER.get());
        }
    }
}
