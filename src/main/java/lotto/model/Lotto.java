package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.message.Error;

public class Lotto {
    public static final Integer PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkOversize(numbers);
        checkDuplicate(numbers);
        this.numbers = numbers;
    }

    private void checkOversize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OVERSIZE.getMessage());
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
