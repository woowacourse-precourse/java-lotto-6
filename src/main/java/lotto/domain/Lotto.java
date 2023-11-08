package lotto.domain;

import lotto.exception.CustomException;
import lotto.exception.constant.ErrorCode;
import lotto.utils.Constant;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Collections.sort(numbers);
    }

    public int[] convertArray() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public boolean contain(int bonusNum) {
        return numbers.contains(bonusNum);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
