package lotto.domain;

import static lotto.exception.ErrorMessage.LOTTO_NUMBER_HAS_DUPLICATED_NUMBER;
import static lotto.exception.ErrorMessage.LOTTO_NUMBER_HAS_OUT_OF_BOUND_NUMBER;
import static lotto.exception.ErrorMessage.LOTTO_SIZE_IS_NOT_VALID;
import static lotto.constraint.LottoConstraint.TOTAL_NUMBERS_OF_LOTTO;
import static lotto.constraint.LottoConstraint.LOTTO_MINIMUM_BOUND;
import static lotto.constraint.LottoConstraint.LOTTO_MAXIMUM_BOUND;

import java.util.Collections;
import java.util.List;
import lotto.exception.InputException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLottoNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateDuplicatedNumber(numbers);
        validateNumberRange(numbers);
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (!isValidLottoSize(numbers)) {
            throw InputException.from(LOTTO_SIZE_IS_NOT_VALID);
        }
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        if (hasDuplicatedNumber(numbers)) {
            throw InputException.from(LOTTO_NUMBER_HAS_DUPLICATED_NUMBER);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (!isInRange(numbers)) {
            throw InputException.from(LOTTO_NUMBER_HAS_OUT_OF_BOUND_NUMBER);
        }
    }

    private boolean isValidLottoSize(List<Integer> numbers) {
        return numbers.size() == TOTAL_NUMBERS_OF_LOTTO.getValue();
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != TOTAL_NUMBERS_OF_LOTTO.getValue();
    }

    private boolean isInRange(List<Integer> numbers) {
        return numbers.stream()
                .allMatch(
                        number -> number >= LOTTO_MINIMUM_BOUND.getValue()
                                && number <= LOTTO_MAXIMUM_BOUND.getValue());
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}