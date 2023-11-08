package lotto.domain;

import lotto.exception.InputException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.configuration.GameConfiguration.LOTTO_NUMBER_SIZE;
import static lotto.exception.errorcode.InputErrorCode.DUPLICATED_LOTTO_NUMBER;
import static lotto.exception.errorcode.InputErrorCode.INVALID_LOTTO_NUMBER_SIZE;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = getSortedNumbers(numbers);
    }

    public int getMatchedCount(final Lotto other) {
        final Set<Integer> distinctNumbers = new HashSet<>(other.numbers);
        distinctNumbers.addAll(numbers);

        return LOTTO_NUMBER_SIZE + (LOTTO_NUMBER_SIZE - distinctNumbers.size());
    }

    public int getNumberFromIndex(final int index) {
        return numbers.get(index);
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    private List<Integer> getSortedNumbers(final List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_SIZE) {
            throw new InputException(INVALID_LOTTO_NUMBER_SIZE);
        }
    }

    private void validateDuplicate(final List<Integer> numbers) {
        final Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if (distinctNumbers.size() != numbers.size()) {
            throw new InputException(DUPLICATED_LOTTO_NUMBER);
        }
    }
}
