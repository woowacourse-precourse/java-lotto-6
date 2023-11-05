package lotto.domain;

import lotto.exception.InputException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static lotto.configuration.GameConfiguration.LOTTO_NUMBER_SIZE;
import static lotto.exception.errorcode.InputErrorCode.DUPLICATED_LOTTO_NUMBER;
import static lotto.exception.errorcode.InputErrorCode.INVALID_LOTTO_NUMBERS_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    public int getMatchedCount(final Lotto other) {
        long matchedNumbersCount = IntStream.range(0, LOTTO_NUMBER_SIZE)
                .filter(i -> matched(other, i))
                .count();

        if (matchedNumbersCount != (int) matchedNumbersCount) {
            throw new IllegalStateException();
        }

        return (int) matchedNumbersCount;
    }

    private void sortNumbers(final List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new InputException(INVALID_LOTTO_NUMBERS_SIZE);
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new InputException(DUPLICATED_LOTTO_NUMBER);
        }
    }

    private boolean matched(final Lotto lotto, final int index) {
        return numbers.get(index).equals(lotto.numbers.get(index));
    }
}
