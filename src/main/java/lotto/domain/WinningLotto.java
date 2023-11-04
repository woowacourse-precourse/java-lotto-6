package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoRank calculateRank(Lotto lotto) {
        return LottoRank.OUT_RANK;
    }
}
