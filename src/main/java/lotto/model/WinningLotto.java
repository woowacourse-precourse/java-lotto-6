package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final Bonus bonusNumber;

    public WinningLotto(Lotto winningNumbers, Bonus bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber.getNumber();
    }

    public static Result of(int matchCount, boolean hasBonus) {
        return new Result(matchCount, hasBonus);
    }
    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

}
