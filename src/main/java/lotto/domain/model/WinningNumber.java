package lotto.domain.model;

import java.util.List;

public class WinningNumber {
    private  List<Integer> regularWinningNumbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> regularWinningNumbers, int bonusNumber) {
        this.regularWinningNumbers = regularWinningNumbers;
        this.bonusNumber = bonusNumber;
    }

}
