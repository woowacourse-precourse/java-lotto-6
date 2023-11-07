package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lotto.util.Constants;
import lotto.util.exception.DuplicatedLottoNumbersException;
import lotto.util.exception.InvalidLottoLengthException;
import lotto.util.exception.InvalidLottoNumberRangeException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateNumbersRange(numbers);
        validateNumberUniqueness(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_LENGTH) {
            throw new InvalidLottoLengthException();
        }
    }

    private void validateNumbersRange(List<Integer> numbers) {
        boolean hasInvalidNumber = numbers.stream()
                .anyMatch(this::isInvalidNumberRange);
        if (hasInvalidNumber) {
            throw new InvalidLottoNumberRangeException();
        }
    }

    private boolean isInvalidNumberRange(int value) {
        return value < Constants.LOTTO_MIN_NUMBER || value > Constants.LOTTO_MAX_NUMBER;
    }

    private void validateNumberUniqueness(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new DuplicatedLottoNumbersException();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    public boolean contains(int value) {
        return numbers.contains(value);
    }
}
