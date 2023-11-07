
package lotto.domain;

import lotto.constants.ErrorConstants;

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
        checkLength(numbers);
        checkRange(numbers);
        checkDuplicateValue(numbers);
    }

    private void checkLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_INVALID_LENGTH.getData());
        }
    }

    private void checkRange(List<Integer> numbers) {
        for(int num : numbers) {
            if( num <0 || num >46)
                throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_INVALID_RANGE.getData());
        }
    }

    private void checkDuplicateValue(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(numbers.size() != set.size()) {
            throw new IllegalArgumentException(ErrorConstants.ERROR_LOTTO_DUPLICATED_VALUE.getData());
        }
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}