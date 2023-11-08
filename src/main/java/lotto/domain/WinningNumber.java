package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final Numbers numbers;

    public static WinningNumber from(List<Integer> numbers) {
        return new WinningNumber(numbers);
    }

    private WinningNumber(List<Integer> numbers) {
        this.numbers = Numbers.from(numbers);
    }

    public boolean contains(int bonusNumber) {
        return numbers.getValue().contains(bonusNumber);
    }
}