package lotto.model.single;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.Exception.isValidDuplicateNumberException;
import static lotto.Exception.isValidSixNumberException;
import static lotto.util.Constant.ModelClass.LOTTO_NUMBERS_LENGTH;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidSixNumberException(numbers.size());
        checkDuplicateNumber(numbers);
    }

    public void checkDuplicateNumber(List<Integer> numbers) {
        Set<Integer> numSet = new HashSet<>(numbers);
        isValidDuplicateNumberException(numbers.size() == numSet.size());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
