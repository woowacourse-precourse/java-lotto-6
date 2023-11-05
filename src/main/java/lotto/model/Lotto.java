package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("6개를 입력해야 합니다.");
        }
        if (isInvalidRange(numbers)) {
            throw new IllegalArgumentException("1~45 사이만 입력 가능합니다.");
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException("중복된 번호가 존재합니다.");
        }
    }

    private boolean isInvalidRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_RANGE || number > MAX_RANGE) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        HashSet<Integer> unique = new HashSet<>(numbers);
        return unique.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
