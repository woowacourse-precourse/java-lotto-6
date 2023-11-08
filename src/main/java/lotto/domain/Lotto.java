package lotto.domain;

import java.util.*;

import static lotto.constant.DefinedNumber.LOTTO_LENGTH;
import static lotto.constant.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLottoNumberRange(numbers);
        validateLottoNumbersSize(numbers);
        validateDuplicateNumber(numbers);
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number <= 0 || number >= 46) {
                throw new IllegalArgumentException(LOTTO_NUMBERS_RANGE_WARNING);
            }
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS_WARNING);
        }
    }

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_LENGTH_WARNING);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        for (Integer number : numbers) {
            joiner.add(number.toString());
        }
        return joiner.toString();
    }
}
