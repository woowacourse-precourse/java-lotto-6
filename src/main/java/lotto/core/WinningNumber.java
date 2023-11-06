package lotto.core;

import java.util.List;
import static lotto.utils.Validator.*;

public class WinningNumber {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> newWinningNumbers, int newBonusNumber) {
        this.winningNumbers = new Lotto(newWinningNumbers);

        validateIsNumberInRange(newBonusNumber); // 1~45 사이 검사
        this.bonusNumber = newBonusNumber;
    }

    public Lotto getWinningNumbers(){
        return this.winningNumbers;
    }

    public int getBonusNumber(){
        return this.bonusNumber;
    }

}
