package lotto.model;

import java.util.List;

import static lotto.Enum.Constant.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != AMOUNT_OF_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException();
        }

        List<Integer> checking = numbers.stream().distinct().toList();
        if (numbers.size() != checking.size()) {
            throw new IllegalArgumentException();
        }

        for (int number : numbers) {
            if (number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue()) {
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
