package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.LottoConstants;
import lotto.StringConstants;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isValidNumbersSize(numbers)) {
            throw new IllegalArgumentException(
                    StringConstants.FIRST_ERROR_MESSAGE+StringConstants.NUMBERS_SIZE_EXCEPTION_MESSAGE);
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(
                    StringConstants.FIRST_ERROR_MESSAGE+StringConstants.NUMBERS_DUPLICATE_EXCEPTION_MESSAGE);
        }
        if (!isValidRange(numbers)) {
            throw new IllegalArgumentException(
                    StringConstants.FIRST_ERROR_MESSAGE+StringConstants.NUMBERS_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() < LottoConstants.SIZE.getValue();
    }

    private boolean isValidRange(List<Integer> numbers) {
        return numbers.stream()
            .allMatch(i -> i >= LottoConstants.NUMBER_MIN.getValue() && i <= LottoConstants.NUMBER_MAX.getValue());
    }

    private boolean isValidNumbersSize(List<Integer> numbers) {
        return numbers.size() != LottoConstants.SIZE.getValue();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countMatchedNumbers(Lotto other) {
        int count = 0;
        for (int number : this.numbers) {
            if (other.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
