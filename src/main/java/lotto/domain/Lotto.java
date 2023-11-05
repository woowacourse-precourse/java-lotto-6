package lotto.domain;

import java.util.List;
import lotto.constant.Number;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Number.LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
