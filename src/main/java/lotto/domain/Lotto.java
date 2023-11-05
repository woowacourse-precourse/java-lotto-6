package lotto.domain;

import lotto.constants.Value;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Value.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException();
        }
    }


    // TODO: 추가 기능 구현

    public String toString() {
        return numbers.toString();
    }
}
