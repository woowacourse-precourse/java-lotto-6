package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int MINIMUM_LOTTO_NUMBER = 1;
    private static final int MAXIMUM_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (isInvalidSize(numbers)) {
            throw new IllegalArgumentException("로또는 총 6개의 번호로 이루어져야 합니다.");
        }
        if (hasDuplicatedNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호들 중 중복된 숫자가 존재합니다.");
        }
        if (hasOutOfRangeNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean isInvalidSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_SIZE;
    }

    private boolean hasDuplicatedNumber(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    private boolean hasOutOfRangeNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isOutOfRange);
    }

    private boolean isOutOfRange(int number) {
        return number < MINIMUM_LOTTO_NUMBER || number > MAXIMUM_LOTTO_NUMBER;
    }
}
