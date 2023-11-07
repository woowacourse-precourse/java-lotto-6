package lotto.model;

import java.util.List;

public class WinningNumber {
    private List<Integer> numbers;

    private WinningNumber() {}

    public WinningNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
