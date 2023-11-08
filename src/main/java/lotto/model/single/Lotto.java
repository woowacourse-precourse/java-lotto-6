package lotto.model.single;

import lotto.Exception;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Exception.isValidDuplicateNumberException;
import static lotto.Exception.isValidSixNumberException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidSixNumberException(numbers.size());
        checkDuplicateNumber(numbers);
        numbers.forEach(Exception::isValidLottoNumberRangeException);
    }

    public void checkDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        isValidDuplicateNumberException(numbers.size() == numSet.size());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
