package lotto.domain;

import java.util.List;

public class WinningNumbers extends Lotto {
    private final List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        super(numbers);
        this.numbers = numbers;
    }

    public static WinningNumbers from(List<Integer> numbers) {
        return new WinningNumbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
