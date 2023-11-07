package lotto.model;

import lotto.domain.Lotto;

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
