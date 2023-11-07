package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.Config.*;
import static lotto.constant.ErrorMessage.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateCount(numbers);
        validateNotDuplicated(numbers);
        validateInRange(numbers);
        validateAscending(numbers);
        this.numbers = numbers;
    }

    public static Lotto create() {
        return new Lotto(
                pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_COUNT)
                        .stream()
                        .sorted()
                        .toList()
        );
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_NOT_MATCHED);
        }
    }

    private void validateNotDuplicated(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() < numbers.size()) {
            throw new IllegalArgumentException(LOTTO_DUPLICATED);
        }
    }

    private void validateInRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException(LOTTO_NOT_IN_RANGE);
        }
    }

    private void validateAscending(List<Integer> numbers) {
        if (IntStream.range(1, numbers.size())
                .map(index -> numbers.get(index - 1).compareTo(numbers.get(index)))
                .anyMatch(order -> order > 0)) {
            throw new IllegalArgumentException(LOTTO_NOT_ASCENDING);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
