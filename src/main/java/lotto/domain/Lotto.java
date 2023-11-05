package lotto.domain;

import lotto.exception.InputException;
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
        this.numbers = numbers;
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

    public int getMatchedNumbersCount(final Lotto other) {
        long matchedNumbersCount = IntStream.range(0, LOTTO_NUMBER_SIZE)
                .filter(i -> matched(other, i))
                .count();

        if (matchedNumbersCount != (int) matchedNumbersCount) {
            throw new IllegalStateException();
        }

        return (int) matchedNumbersCount;
    }

    @Override
    public boolean equals(final Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof final Lotto lotto)) {
            return false;
        }

        for (int i = 0; i < LOTTO_NUMBER_SIZE; i++) {
            if (matched(lotto, i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();  // 원소의 해시테그를 일일히 비교하는데, Integer의 경우 해시값이 저장된 값이므로 상관없음
    }

    private boolean matched(final Lotto lotto, final int index) {
        return numbers.get(index).equals(lotto.numbers.get(index));
    }
}
