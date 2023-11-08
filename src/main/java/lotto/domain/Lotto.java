package lotto.domain;

import java.util.List;

import static lotto.domain.DomainError.*;
import static lotto.domain.LottoStandard.*;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplicatedNumbers(numbers);
        validateNumberRange(numbers);

        this.numbers = numbers;
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != SIZE.getNumber()) {
            throw new IllegalArgumentException(LOTTO_SIZE_ERROR.getMessage());
        }
    }

    private void validateDuplicatedNumbers(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (numbers.contains(number)) {
                throw new IllegalArgumentException(LOTTO_DUPLICATE_ERROR.getMessage());
            }
        }
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number < MIN.getNumber() || number > MAX.getNumber()) {
                throw new IllegalArgumentException(LOTTO_RANGE_ERROR.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
