package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private static List<Lotto> winningNumber;
    private int bonusNumber;

    public WinningNumber(List<Lotto> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }
    public List<Lotto> getWinningNumber() {
        return winningNumber;
    }
    public int getBonusNumber() {
        return bonusNumber;
    }
}
