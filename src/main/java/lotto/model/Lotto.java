package lotto.model;

import java.util.List;
import lotto.constant.Number;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Number.LOTTO_LENGTH_LIMIT.getMessage()) {
            throw new IllegalArgumentException();
        }
    }


}
