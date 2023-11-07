package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.constants.LottoRule;
import lotto.common.exception.LottoErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicatedNumber(numbers);
        validateLottoNumberRange(numbers);

        sort(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers != null && numbers.size() != LottoRule.LOTTO_NUMBER_SIZE.value) {
            throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_NUMBERS_SIZE.getValue(numbers));
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (number < LottoRule.LOTTO_NUMBER_MIN.value || LottoRule.LOTTO_NUMBER_MAX.value < number) {
                throw new IllegalArgumentException(LottoErrorMessage.INVALID_LOTTO_NUMBER_RANGE.getValue(numbers));
            }
        });
    }

    private void validateDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LottoRule.LOTTO_NUMBER_SIZE.value) {
            throw new IllegalArgumentException(LottoErrorMessage.DUPLICATED_NUMBER.getValue(numbers));
        }
    }

    private void sort(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
