package lotto.domain;

import java.util.List;

public class Target {
    private List<Integer> numbers;
    private int bonusNumber;

    public Target(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public static Target createTarget(List<Integer> targetNumbers, int bonusNumber) {
        return new Target(targetNumbers, bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
