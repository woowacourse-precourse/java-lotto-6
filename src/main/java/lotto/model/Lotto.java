package lotto.model;

import static lotto.util.Constant.LOTTO_MAX_RANGE;
import static lotto.util.Constant.LOTTO_MIN_RANGE;
import static lotto.util.Constant.LOTTO_NUMBERS_COUNT;
import static lotto.util.ErrorMessage.ERROR_LOTTO_DUPLICATE;
import static lotto.util.ErrorMessage.ERROR_LOTTO_OUT_OF_RANGE;
import static lotto.util.ErrorMessage.ERROR_LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE);
        }
        validateDuplicate(numbers);
        validateRangeOfNumbers(numbers);
        sortedLotto(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicate = new HashSet<>(numbers);
        if (nonDuplicate.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATE);
        }
    }

    private void validateRangeOfNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < LOTTO_MIN_RANGE || number > LOTTO_MAX_RANGE) {
                throw new IllegalArgumentException(ERROR_LOTTO_OUT_OF_RANGE);
            }
        }
    }

    private List<Integer> sortedLotto(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
