package lotto;

import static lotto.util.Constant.LOTTO_NUMBERS_COUNT;
import static lotto.util.ErrorMessage.ERROR_LOTTO_DUPLICATE;
import static lotto.util.ErrorMessage.ERROR_LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicate = new HashSet<>(numbers);
        if (nonDuplicate.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATE);
        }
    }
}
