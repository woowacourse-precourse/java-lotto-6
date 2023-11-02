package lotto.domain;

import static lotto.exception.ErrorMessage.*;

import java.util.*;
import lotto.exception.LottoException;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> inputNumbers) {
        validate(inputNumbers);
        this.numbers = inputNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new LottoException(LOTTO_NUMBER_COUNT_ERROR);
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new LottoException(LOTTO_NUMBER_DUPLICATED_ERROR);
        }
        if (hasOverRangedNumber(numbers)) {
            throw new LottoException(LOTTO_NUMBER_RANGE_ERROR);
        }
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    private boolean hasOverRangedNumber(List<Integer> numbers) {
        return !numbers.stream()
                .allMatch(number -> number >= MIN_LOTTO_NUMBER && number <= MAX_LOTTO_NUMBER);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
