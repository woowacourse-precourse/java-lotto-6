package lotto.domain;

import java.util.List;

public class WinningNumber {
    private List<Integer> prizeNumbers;
    private int bonusNumber;

    public WinningNumber(List<Integer> prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
