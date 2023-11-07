package lotto.domain;

import static lotto.constant.ExceptionMessage.ERROR_DUPLICATE_NUMBERS;
import static lotto.constant.ExceptionMessage.ERROR_LOTTO_NUMBER_RANGE;
import static lotto.constant.ExceptionMessage.ERROR_NOT_NUMBERS_SIZE;
import static lotto.constant.LottoConstant.LOTTO_END_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_START_NUMBER;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicateNumbers(numbers);
        validateLottoNumberRange(numbers);
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBERS_SIZE);
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> notDuplicateNumbers = new HashSet<>(numbers);

        if (notDuplicateNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS);
        }
    }

    private void validateLottoNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException(ERROR_LOTTO_NUMBER_RANGE);
            }
        }
    }

    // TODO: 추가 기능 구현
}
