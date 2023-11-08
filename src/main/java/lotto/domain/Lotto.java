package lotto.domain;

import static lotto.domain.constants.ErrorMessage.DUPLICATED_NUMBER;
import static lotto.domain.constants.ErrorMessage.INVALID_NUMBER_COUNT;
import static lotto.domain.constants.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.domain.constants.LottoNumber.MAX_NUMBER;
import static lotto.domain.constants.LottoNumber.MIN_NUMBER;
import static lotto.domain.constants.LottoNumber.NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplicates(numbers);
        checkRange(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private void checkDuplicates(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_NUMBER.getMessage());
        }
    }

    private void checkRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException(INVALID_NUMBER_RANGE.getMessage());
            }
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }

}
