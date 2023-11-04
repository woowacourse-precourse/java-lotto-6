package lotto.dto;

import lotto.domain.lotto.Lotto;

public class LottoResult {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoResult(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
