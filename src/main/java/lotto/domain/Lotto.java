package lotto.domain;

import lotto.enumeration.ExceptionType;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionType.INVALID_LOTTO_FORMAT.getMessage());
        }
        if(numbers.stream().distinct().count() < 6) {
            throw new IllegalArgumentException(ExceptionType.DUPLICATE_LOTTO_NUMS.getMessage());
        }
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException(ExceptionType.EXCEED_LOTTO_RANGE.getMessage());
            }
        }
    }

    public void printNumbers() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
