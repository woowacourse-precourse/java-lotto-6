package lotto.domain;

import static lotto.domain.enums.Constant.LOTTO_MAX_NUMBER;
import static lotto.domain.enums.Constant.LOTTO_MIN_NUMBER;
import static lotto.domain.enums.Constant.LOTTO_NUMBER_LENGTH;
import static lotto.domain.enums.ErrorMessage.DUPLICATE_NUMBER_ERROR_MESSAGE;
import static lotto.domain.enums.ErrorMessage.EXCEED_LENGTH_ERROR_MESSAGE;
import static lotto.domain.enums.ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR_MESSAGE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateLottoNumberLength(numbers);
        validateNumberRange(numbers);
        validateDuplicateNumber(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateLottoNumberLength(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.getConstant()) {
            throw new IllegalArgumentException(EXCEED_LENGTH_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateDuplicateNumber(final List<Integer> numbers) {
        if (hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }

    private void validateNumberRange(final List<Integer> numbers) {
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException(NUMBER_OUT_OF_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isOutOfRange(final List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number < LOTTO_MIN_NUMBER.getConstant()
                        || number > LOTTO_MAX_NUMBER.getConstant());
    }

    private boolean hasDuplicateNumber(final List<Integer> numbers) {
        return (new HashSet<>(numbers).size() != numbers.size());
    }

    public boolean isContainNumber(final int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

}
