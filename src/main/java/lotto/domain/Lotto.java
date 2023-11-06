package lotto.domain;

import static lotto.domain.exception.LottoException.DUPLICATED_LOTTO_NUMBER;
import static lotto.util.Constants.LOTTO_NUMBERS_SIZE;
import static lotto.domain.exception.LottoException.INVALID_LOTTO_SIZE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.LottoUtil;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        numbers.forEach(LottoUtil::verifyRangeOfLottoNumber);
    }

    private static void validateDuplication(List<Integer> numbers) {
        if (hasDuplicateNumbers(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean hasDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
