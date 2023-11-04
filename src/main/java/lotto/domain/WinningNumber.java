package lotto.domain;

import lotto.Lotto;

import java.util.List;

public class WinningNumber {
    private Lotto winnerLotto;
    private int bonusNumber;
    public WinningNumber(final Lotto winnerLotto, final int bonusNumber) {
        this.winnerLotto = winnerLotto;
        this.bonusNumber = bonusNumber;
    }
}
