package lotto.domain;

import lotto.constant.LottoRank;

public class WinningLotto {
    private final Lotto lotto;
    private int bonusNumber;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public LottoRank calculateRank(Lotto lotto) {
        return LottoRank.OUT_RANK;
    }
}
