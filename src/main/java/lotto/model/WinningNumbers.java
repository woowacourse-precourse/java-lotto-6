package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> sixNumbers;
    private final int bonusNumber;

    private WinningNumbers(List<Integer> sixNumbers, int bonusNumber) {
        this.sixNumbers = sixNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public List<Integer> getSixNumbers() {
        return sixNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
