package lotto.domain;

import lotto.error.LottoErrorMessage;
import lotto.util.constant.LottoConstant;

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
        if (!validateNumbersSize(numbers)) {
            throw new IllegalArgumentException(LottoErrorMessage.OVER_LOTTO_FIX_SIZE_EXCEPTION.getMessage());
        }

        if (!validateDuplicationNumbers(numbers)) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATE_NUMBER_EXCEPTION.getMessage());
        }
    }

    private boolean validateNumbersSize(List<Integer> numbers) {
        return numbers.size() == LottoConstant.LOTTO_COUNT;
    }

    private boolean validateDuplicationNumbers(List<Integer> numbers) {
        Set<Integer> deduplicationNumbers = new HashSet<>(numbers);
        return deduplicationNumbers.size() == LottoConstant.LOTTO_COUNT;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
