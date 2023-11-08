package lotto.domain;

import static lotto.domain.constants.LottoConfig.LOTTO_NUMBER_MAX;
import static lotto.domain.constants.LottoConfig.LOTTO_NUMBER_MIN;
import static lotto.domain.constants.LottoConfig.LOTTO_SIZE;
import static lotto.exception.constants.ErrorMessage.DUPLICATE_LOTTO_NUMBERS;
import static lotto.exception.constants.ErrorMessage.LOWER_SIZE_LOTTO;
import static lotto.exception.constants.ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBERS;
import static lotto.exception.constants.ErrorMessage.OVER_SIZE_LOTTO;

import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortNumbers(numbers);
    }

    private List<Integer> sortNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumbers(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersRange(final List<Integer> numbers) {
        if (numbers.stream()
                .anyMatch(num ->
                        num < LOTTO_NUMBER_MIN.getValue() || num > LOTTO_NUMBER_MAX.getValue())) {
            throw LottoException.of(OUT_OF_RANGE_LOTTO_NUMBERS);
        }
    }

    private void validateDuplicateNumbers(final List<Integer> numbers) {
        if (numbers.stream()
                .distinct().count()
                != numbers.size()) {
            throw LottoException.of(DUPLICATE_LOTTO_NUMBERS);
        }
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() > LOTTO_SIZE.getValue()) {
            throw LottoException.of(OVER_SIZE_LOTTO);
        }
        if (numbers.size() < LOTTO_SIZE.getValue()) {
            throw LottoException.of(LOWER_SIZE_LOTTO);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
