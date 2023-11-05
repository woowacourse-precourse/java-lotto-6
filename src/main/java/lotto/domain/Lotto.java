package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static lotto.view.ExceptionMessage.*;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        numbers = sorted(numbers);
        this.numbers = numbers;
    }

    private List<Integer> sorted(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateDuplicatedCheck(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(sizeException() + numbers.size());
        }
    }


    private void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        for (int number : numbers) {
            if (number < MIN_RANGE || number > MAX_RANGE) {
                throw new IllegalArgumentException(rangeException());
            }
        }
    }

    private void validateDuplicatedCheck(List<Integer> numbers) {
        Set<Integer> duplicateCheck = new HashSet<>();
        for (int number : numbers) {
            duplicateCheck.add(number);
        }
        duplicatedChecking(duplicateCheck);
    }

    private void duplicatedChecking(Set<Integer> duplicateCheck) {
        if (duplicateCheck.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(duplicatedException());
        }
    }

    public boolean isContain(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int getMatchLotto(WinningNumber winningNumber) {
        return (int) numbers.stream().
                filter(winningNumber::isContain).
                count();
    }
}
