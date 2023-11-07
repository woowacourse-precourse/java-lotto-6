package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.constant.ConfigurationNumbers;
import lotto.constant.ExceptionMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isUnvalidLength(numbers);
        isDuplicated(numbers);
        isOutOfRange(numbers);
    }

    private void isUnvalidLength(List<Integer> numbers) {
        if (numbers.size() != ConfigurationNumbers.LOTTO_LENGTH.getNumber()) {
            throw new IllegalArgumentException(ExceptionMessage.UNVALID_LENGTH.getMessage());
        }
    }

    private void isDuplicated(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numbers.size() != numberSet.size()) {
            throw new IllegalArgumentException(ExceptionMessage.IS_DUPLICATED.getMessage());
        }
    }

    private void isOutOfRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < ConfigurationNumbers.MIN_NUMBER.getNumber()
                    || num > ConfigurationNumbers.MAX_NUMBER.getNumber()) {
                throw new IllegalArgumentException(ExceptionMessage.OUT_OF_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
