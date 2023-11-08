package lotto.domain;

import lotto.view.ExceptionMessage;

import java.util.*;

public class Lotto {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOverlap(numbers);
        validateRange(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validateRange(List<Integer> numbers) {
        for (int winningNumber = 0; winningNumber < numbers.size(); winningNumber++) {
            if (numbers.get(winningNumber) < MIN_NUMBER || numbers.get(winningNumber) > MAX_NUMBER) {
                ExceptionMessage.wrongValueException();
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateOverlap(List<Integer> numbers) {
        Set<Integer> overlapCheck = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            overlapCheck.add(numbers.get(i));
        }
        if (overlapCheck.size() != 6) {
            ExceptionMessage.wrongValueException();
            throw new IllegalArgumentException();
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
