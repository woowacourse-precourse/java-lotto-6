package lotto.domain;

import lotto.Lotto;

public class WinningLotto {

    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContain(int number) {
        return lotto.isContain(number);
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
