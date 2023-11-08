package lotto.domain;

import static lotto.constant.ErrorMessage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final static int START_NUM = 1;
    private final static int END_NUM = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumbersSize(numbers);
        checkNumbersDuplicate(numbers);
        checkNumbersRange(numbers);
    }

    private void checkNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(WRONG_LENGTH.getMessage());
        }
    }

    private void checkNumbersDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    private void checkNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < START_NUM || number > END_NUM) {
                throw new IllegalArgumentException(OUT_OF_NUMBER_RANGE.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }


}






