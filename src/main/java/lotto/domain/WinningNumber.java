package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final Lotto lotto;
    private int bonusNumber;

    public WinningNumber(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
