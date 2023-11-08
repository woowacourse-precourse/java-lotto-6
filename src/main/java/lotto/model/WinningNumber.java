package lotto.model;

import java.util.List;

public class WinningNumber {
    private Integer bonusNumber;
    private List<Integer> numbers;

    private WinningNumber() {}

    public WinningNumber(List<Integer> mainNumbers, Integer bonusNumber) {
        this.numbers = mainNumbers;
        this.bonusNumber = bonusNumber;
    }
}
