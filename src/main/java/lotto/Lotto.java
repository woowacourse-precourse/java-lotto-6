package lotto;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_SIZE);
        }
    }

    // TODO: 추가 기능 구현
    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> nonDuplicate = new HashSet<>(numbers);
        if (nonDuplicate.size() != 6) {
            throw new IllegalArgumentException(ERROR_LOTTO_DUPLICATE);
        }
    }
}
