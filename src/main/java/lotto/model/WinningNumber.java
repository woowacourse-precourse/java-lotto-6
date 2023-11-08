package lotto.model;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;
    private final Integer bonusNum;

    public WinningNumber(List<Integer> numbers, Integer bonusNum) {
        this.numbers = numbers;
        this.bonusNum = bonusNum;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNum() {
        return bonusNum;
    }
}
