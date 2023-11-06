package lotto.model;

import static lotto.Constants.Constants.LOTTO_NUMBER_COUNT;
import static lotto.Constants.Constants.MAX_RANDOM_NUMBER;
import static lotto.Constants.Constants.MIN_RANDOM_NUMBER;
import static lotto.exception.LottoErrorCode.LOTTO_NUMBER_DUPLICATE;
import static lotto.exception.LottoErrorCode.LOTTO_NUMBER_RANGE;
import static lotto.exception.LottoErrorCode.LOTTO_NUMBER_SIZE;

import java.util.Collections;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNotDuplicate(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new LottoException(LOTTO_NUMBER_SIZE);
        }
    }

    private void validateNotDuplicate(final List<Integer> numbers) {
        if (isDuplicate(numbers)) {
            throw new LottoException(LOTTO_NUMBER_DUPLICATE);
        }
    }

    private void validateNumbersRange(final List<Integer> numbers) {
        numbers.forEach(this::validateNumberRange);
    }

    private void validateNumberRange(final int number) {
        if (number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER) {
            throw new LottoException(LOTTO_NUMBER_RANGE);
        }
    }

    private boolean isDuplicate(final List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }

    public String numbersToString() {
        return numbers.toString();
    }

}