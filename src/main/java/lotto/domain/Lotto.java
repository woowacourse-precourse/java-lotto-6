package lotto.domain;

import static lotto.message.ErrorMessage.DUPLICATE_EXCEPTION_MESSAGE;
import static lotto.message.ErrorMessage.NUMBER_RANGE_EXCEPTION_MESSAGE;
import static lotto.message.ErrorMessage.SIX_DIGITS_EXCEPTION_MESSAGE;
import static lotto.message.MessageConstants.LOTTO_MAX_NUMBER;
import static lotto.message.MessageConstants.LOTTO_MIN_NUMBER;
import static lotto.message.MessageConstants.LOTTO_SIZE;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;

        validateNumbers(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumberOfDigits(numbers);
        validateNumberRange(numbers);
        validateDuplicatedNumbers(numbers);
    }

    private void validateNumberOfDigits(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(SIX_DIGITS_EXCEPTION_MESSAGE);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
    
}
