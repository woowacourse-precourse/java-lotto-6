package lotto.number;

import static lotto.exception.ExceptionMessage.DUPLICATED_LOTTO_NUMBERS;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_RANGE;
import static lotto.exception.ExceptionMessage.INVALID_LOTTO_NUMBER_SIZE;
import static lotto.service.LottoConstant.LOTTO_END_NUMBER;
import static lotto.service.LottoConstant.LOTTO_NUMBER_COUNT;
import static lotto.service.LottoConstant.LOTTO_START_NUMBER;

import java.util.ArrayList;
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
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalStateException(INVALID_LOTTO_NUMBER_SIZE.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalStateException(DUPLICATED_LOTTO_NUMBERS.getMessage());
        }

        if (!uniqueNumbers.stream()
                .allMatch(number -> (LOTTO_START_NUMBER <= number) && (number <= LOTTO_END_NUMBER))) {
            throw new IllegalStateException(INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
