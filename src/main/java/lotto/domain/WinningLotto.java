package lotto.domain;

import lotto.Lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto lotto, BonusNumber bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }
}
