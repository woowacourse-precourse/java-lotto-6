package lotto.domain;

import lotto.error.ErrorMessage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;
    public static final int MAX_NUMBERS = 6;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;
    public static final int PRICE = 1_000;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto() {
        this.numbers = new ArrayList<>();
    }

    private void isInRange(List<Integer> numbers) {
        for (int num : numbers) {
            if (num < MIN_VALUE || num > MAX_VALUE) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
            }
        }
    }

    private void checkLength(List<Integer> numbers) {
        if (numbers.size() != MAX_NUMBERS) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH);
        }
    }

    protected void validate(List<Integer> numbers) {
        checkLength(numbers);
        isInRange(numbers);
        isUnique(numbers);
    }

    private void isUnique(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBERS);
        }
    }

    protected void isUnique(List<Integer> numbers, int bonusNumber) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBERS);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
