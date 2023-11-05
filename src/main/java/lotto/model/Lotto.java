package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.message.Error;

public class Lotto {
    public static final Integer PRICE = 1000;
    public static final Integer NUMBER_COUNT = 6;
    public static final Integer MIN_NUMBER = 1;
    public static final Integer MAX_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        checkOversize(numbers);
        checkDuplicate(numbers);
        checkOverBound(numbers);
        this.numbers = numbers;
    }

    private void checkOversize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OVERSIZE.getMessage());
        }
    }

    private void checkDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (numbers.size() != uniqueNumbers.size()) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_DUPLICATE.getMessage());
        }
    }

    private void checkOverBound(List<Integer> numbers) {
        numbers.forEach(this::checkInBound);
    }

    private void checkInBound(Integer number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(Error.LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
