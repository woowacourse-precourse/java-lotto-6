package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private static Lotto winningNumber;
    private int bonusNumber;

    public WinningNumber(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
    public Lotto getWinningNumber() {
        return winningNumber;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}
