package lotto.domain;
import static java.util.Collections.*;
import static lotto.constant.ErrorMessage.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.constant.ErrorMessage;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
            .sorted()
            .toList();
    }

    public List<Integer> getNumbers() {
        return unmodifiableList(numbers);
    }

    private void validate(final List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoNumberRange(numbers);
        validateNoDuplicates(numbers);
    }

    private void validateLottoSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_LOTTO_NUMBERS.getMessage());
        }
    }

    private void validateLottoNumberRange(final List<Integer> numbers) {
        final List<Integer> validNumbers = numbers.stream()
            .filter(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER)
            .toList();

        if(validNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }
    private void validateNoDuplicates(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_LOTTO_NUMBERS.getMessage());
        }
    }

}
