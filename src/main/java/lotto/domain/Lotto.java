package lotto.domain;

import lotto.dto.LottoNumbersDTO;

import java.util.List;

import static lotto.constants.DomainConstants.LOTTO_NUMBER_COUNT;
import static lotto.constants.DomainConstants.MAX_LOTTO_NUMBER;
import static lotto.constants.DomainConstants.MIN_LOTTO_NUMBER;
import static lotto.exception.LottoException.BELOW_RANGE_LOTTO_NUMBER;
import static lotto.exception.LottoException.LOTTO_NUMBER_COUNT_NOT_CORRECT;
import static lotto.exception.LottoException.LOTTO_NUMBER_MUST_UNIQUE;
import static lotto.exception.LottoException.OVER_RANGE_LOTTO_NUMBER;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        this.numbers = numbers;
        validate();
    }

    private void validate() {
        if (isNotCorrectNumberCount()) {
            LOTTO_NUMBER_COUNT_NOT_CORRECT.create();
        }
        if (isNotUniqueNumber()) {
            LOTTO_NUMBER_MUST_UNIQUE.create();
        }
        if (isBelowRangeNumber()) {
            BELOW_RANGE_LOTTO_NUMBER.create();
        }
        if (isOverRangeNumber()) {
            OVER_RANGE_LOTTO_NUMBER.create();
        }
    }

    private boolean isNotCorrectNumberCount() {
        return numbers.size() != LOTTO_NUMBER_COUNT.getValue();
    }

    private boolean isNotUniqueNumber() {
        return numbers.stream()
                .distinct()
                .count() != LOTTO_NUMBER_COUNT.getValue();
    }

    private boolean isBelowRangeNumber() {
        return numbers.stream()
                .anyMatch(number -> number < MIN_LOTTO_NUMBER.getValue());
    }

    private boolean isOverRangeNumber() {
        return numbers.stream()
                .anyMatch(number -> number > MAX_LOTTO_NUMBER.getValue());
    }

    public LottoNumbersDTO toDTO() {
        return new LottoNumbersDTO(numbers.stream()
                .map(String::valueOf)
                .toList());
    }

    public boolean contains(final int otherNumber) {
        return numbers.stream()
                .anyMatch(number -> number == otherNumber);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }
}
