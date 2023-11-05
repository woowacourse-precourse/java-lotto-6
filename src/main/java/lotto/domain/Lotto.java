package lotto.domain;

import lotto.exception.InputException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
