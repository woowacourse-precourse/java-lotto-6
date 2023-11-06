package lotto.domain;

import static lotto.domain.constants.LottoConfig.LOTTO_NUMBER_MAX;
import static lotto.domain.constants.LottoConfig.LOTTO_NUMBER_MIN;
import static lotto.domain.constants.LottoConfig.LOTTO_SIZE;
import static lotto.exception.ErrorMessage.DUPLICATE_LOTTO_NUMBERS;
import static lotto.exception.ErrorMessage.OUT_OF_RANGE_LOTTO_NUMBERS;

import java.util.Collections;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumbers(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersRange(List<Integer> numbers) {
        if (numbers.stream()
                .allMatch
                        (num -> num >= LOTTO_NUMBER_MIN.getValue() && num <= LOTTO_NUMBER_MAX.getValue())) {
            throw LottoException.of(OUT_OF_RANGE_LOTTO_NUMBERS);
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        if (numbers.stream()
                .distinct().count()
                != numbers.size()) {
            throw LottoException.of(DUPLICATE_LOTTO_NUMBERS);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
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
