package lotto.model;

import static lotto.util.Constant.LOTTO_NUMBER_COUNT;

import java.util.Collections;
import java.util.List;
import lotto.exception.ExistDuplicatedNumberException;
import lotto.exception.InvalidLottoNumberException;

public class WinningNumber {

    private final List<Integer> numbers;

    public WinningNumber(final List<Integer> numbers) {
        validateSixNumbers(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateSixNumbers(final List<Integer> numbers) {
        if (!hasSixNumbers(numbers)) {
            throw new InvalidLottoNumberException(numbers);
        }
    }

    private boolean hasSixNumbers(final List<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_COUNT.getValue();
    }

    private void validateDuplicateNumbers(final List<Integer> numbers) {
        if (hasDuplicate(numbers)) {
            throw new ExistDuplicatedNumberException(numbers);
        }
    }

    private boolean hasDuplicate(final List<Integer> numbers) {
        int distinctCount = (int) numbers.stream()
                .distinct()
                .count();
        return distinctCount != numbers.size();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
