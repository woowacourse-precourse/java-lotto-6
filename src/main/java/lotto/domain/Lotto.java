package lotto.domain;

import static lotto.domain.LottoNumber.EXACT_LOTTO_COUNTS;
import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;
import static lotto.exception.ExceptionMessage.LOTTO_COUNTS_INVALID;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBERS_DUPLICATED;
import static lotto.exception.ExceptionMessage.LOTTO_NUMBER_OUT_OF_RANGE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.LottoGameException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new LottoGameException(String.format(LOTTO_COUNTS_INVALID.getMessage(), numbers.size()));
        }
        if (isNumberOutOfRange(numbers)) {
            throw new LottoGameException(String.format(LOTTO_NUMBER_OUT_OF_RANGE.getMessage(), numbers));
        }
        if (isDuplicated(numbers)) {
            throw new LottoGameException(String.format(LOTTO_NUMBERS_DUPLICATED.getMessage(), numbers));
        }
    }

    private static boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != EXACT_LOTTO_COUNTS.getNumber();
    }

    private static boolean isNumberOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < MIN_LOTTO_NUMBER.getNumber() || MAX_LOTTO_NUMBER.getNumber() < number);
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        return numbers.stream().distinct().count() != EXACT_LOTTO_COUNTS.getNumber();
    }

    public List<Integer> getNumbers() {
        return this.numbers.stream()
                .collect(Collectors.toUnmodifiableList());
    }
}
