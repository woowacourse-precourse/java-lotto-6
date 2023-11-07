package lotto.model;

import java.util.Collections;
import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
