package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningNumbers(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
}
