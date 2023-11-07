package lotto.model;

import java.util.List;

import static lotto.utils.Constants.LOTTO_DRAW_NUMBER_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_DRAW_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

}
