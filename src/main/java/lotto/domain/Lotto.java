package lotto.domain;

import lotto.exception.ErrorCode;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        //sortLotto(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    // TODO: 추가 기능 구현

    public List<Integer> getLotto() {
        return this.numbers;
    }

    private void sortLotto(List<Integer> numbers) {
        Collections.sort(numbers);
    }


}
