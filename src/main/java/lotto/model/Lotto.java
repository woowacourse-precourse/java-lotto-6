package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.exception.LottoException;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
        numbers = sortNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoException.NOT_SIX_NUMBERS.getExceptionMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> distinctNumbers = new HashSet<>(numbers);
        if (numbers.size() != distinctNumbers.size()) {
            throw new IllegalArgumentException(LottoException.NOT_DUPLICATE.getExceptionMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        boolean allInRange = numbers.stream()
                .allMatch(num -> num >= 1 && num <= 45);

        if (!allInRange) {
            throw new IllegalArgumentException(LottoException.INVALID_RANGE.getExceptionMessage());
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        return mutableNumbers;
    }
}
