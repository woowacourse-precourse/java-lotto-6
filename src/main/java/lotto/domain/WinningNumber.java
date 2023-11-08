package lotto.domain;

import java.util.Collections;
import java.util.List;
import lotto.message.Error;
import lotto.util.Validation;

public class WinningNumber {

    private static final int winningNumberCount = 6;

    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        if (!Validation.hasCorrectSize(numbers)) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_COUNT.getMessage(winningNumberCount));
        }
        if (!Validation.hasCorrectRange(numbers)) {
            throw new IllegalArgumentException(Error.INVALID_NUMBER_RANGE.getMessage());
        }
        if (Validation.hasDuplicate(numbers)) {
            throw new IllegalArgumentException(Error.DUPLICATE_NUMBER_EXIST.getMessage());
        }
        this.numbers = Collections.unmodifiableList(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
