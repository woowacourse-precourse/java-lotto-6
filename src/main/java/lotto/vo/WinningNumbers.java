package lotto.vo;

import java.util.List;

public final class WinningNumbers {
    private final List<Integer> numbers;

    private WinningNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static WinningNumbers from(List<Integer> numbers) {
        return new WinningNumbers(numbers);
    }

    public boolean isContained(int number) {
        return numbers.contains(number);
    }
}
