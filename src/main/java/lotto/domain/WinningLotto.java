package lotto.domain;

import java.util.List;
import lotto.constant.ErrorMessage;

public class WinningLotto{
    private final Lotto lotto;
    private final int bonusNumber;
    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
