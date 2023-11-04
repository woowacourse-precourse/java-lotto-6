package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ValidationUtils;

public class Lotto {

    private final List<Integer> numbers;
    private final int LOTTO_SIZE_CRITERION = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ValidationUtils.validateNotNull(numbers);
        validateLottoNumbersSize(numbers);
        validateNoDuplicatedLottoNumbers(numbers);
    }

    private void validateLottoNumbersSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicatedLottoNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != LOTTO_SIZE_CRITERION) {
            throw new IllegalArgumentException();
        }
    }
}
