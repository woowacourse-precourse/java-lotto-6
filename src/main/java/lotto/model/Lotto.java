package lotto.model;

import static lotto.common.Constant.LOTTO_NUMBERS_SIZE;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto issue(List<Integer> numbers) {
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (hasOverSize(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasOverSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_NUMBERS_SIZE;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
