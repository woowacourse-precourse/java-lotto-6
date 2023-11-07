package lotto.core;

import java.util.List;
import static lotto.utils.Validator.*;

public class WinningNumber {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> newWinningNumbers, int newBonusNumber) {
        this.winningNumbers = new Lotto(newWinningNumbers);
        this.bonusNumber = newBonusNumber;
    }

    public Lotto getWinningNumbers(){
        return winningNumbers;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }

}
