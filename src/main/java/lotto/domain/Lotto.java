package lotto.domain;

import lotto.service.LottoGame;
import lotto.util.InputValidator;

import java.util.List;

import static lotto.exception.ErrorMessage.*;
import static lotto.exception.ExceptionHandler.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicateNumber(numbers);
        validateNumberRange(numbers);
        this.numbers = sortNumbersInAsc(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoGame.LOTTO_SELECTION_COUNT) {
            triggerArgException(INVALID_LOTTO_NUMBER_LENGTH);
        }
    }

    private void validateDuplicateNumber(List<Integer> numbers) {
        if (InputValidator.isDuplicate(numbers)) {
            triggerArgException(DUPLICATE_LOTTO_NUMBER);
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!InputValidator.isInRange(number)) {
                triggerArgException(NO_WITHIN_SCOPE_LOTTO_NUMBER);
            }
        }
    }

    private List<Integer> sortNumbersInAsc(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public List<String> getStringNumbers() {
        return this.numbers.stream()
                .map(Object::toString)
                .toList();
    }
}
