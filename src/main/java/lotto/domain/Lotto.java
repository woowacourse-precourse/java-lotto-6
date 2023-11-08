package lotto.domain;

import lotto.type.ConstNumberType;
import lotto.type.ErrorMessageType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        validateSizeException(numbers);
        validateDuplicatedExcepiton(numbers);
        validateNumberRangeException(numbers);
    }

    private void validateSizeException(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != ConstNumberType.LOTTO_SIZE.number()) {
            throw new IllegalArgumentException(ErrorMessageType.NOT_SIZE_SIX.message());
        }
    }

    private void validateDuplicatedExcepiton(List<Integer> numbers) throws IllegalArgumentException {
        Set<Integer> setNumbers = new HashSet<>(numbers);
        if (setNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessageType.DUPLICATE_NUMBER.message());
        }
    }

    private void validateNumberRangeException(List<Integer> numbers) throws IllegalArgumentException {
        long result = numbers.stream()
                .filter(num -> num < ConstNumberType.LOTTO_START_NUMBER.number() || num > ConstNumberType.LOTTO_END_NUMBER.number())
                .count();
        if (result != 0) {
            throw new IllegalArgumentException(ErrorMessageType.OUT_OF_LOTTO_NUMERICAL_RANGE.message());
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
