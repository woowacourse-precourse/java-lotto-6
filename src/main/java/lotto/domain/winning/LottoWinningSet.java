package lotto.domain.winning;

import lotto.domain.lotto.Lotto;
import lotto.vo.BonusNumber;

public class LottoWinningSet {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public LottoWinningSet(final Lotto lotto, final BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
