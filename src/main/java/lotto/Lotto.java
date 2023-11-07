package lotto;

import enums.LottoError;

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
            throw new IllegalArgumentException(LottoError.NUMBER_COUNT_ERROR.getMessage());
        }

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(LottoError.NUMBER_RANGE_ERROR.getMessage());
            }

            if (uniqueNumbers.contains(number)) {
                throw new IllegalArgumentException(LottoError.NUMBER_DUPLICATE_ERROR.getMessage());
            }
            uniqueNumbers.add(number);
        }
    }

}
