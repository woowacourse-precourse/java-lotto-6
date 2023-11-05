package lotto.domain.winning;

import lotto.domain.lotto.Lotto;
import lotto.vo.BonusNumber;

public class LottoWinningNumbers {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public LottoWinningNumbers(final Lotto lotto, final BonusNumber bonusNumber) {
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
