package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Error.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateNumbersVal(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }


    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_NUMBERS_SIZE.getErrMsg());
        }
    }

    private void validateNumbersVal(List<Integer> numbers) {
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                throw new IllegalArgumentException(INVALID_NUMBERS_VALUE.getErrMsg());
            }
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> temp = new HashSet<>();
        for (Integer number : numbers) {
            if (!temp.add(number)) {
                throw new IllegalArgumentException(DUPLICATE_NUMBERS.getErrMsg());
            }
        }
    }
}