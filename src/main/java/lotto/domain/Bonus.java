package lotto.domain;

import static lotto.constant.GameNumber.BONUS_NUMBER_COUNT;

import java.util.List;

public class Bonus {

    private final List<Integer> numbers;

    public Bonus(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != BONUS_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException();
        }
    }
}
