package domain;

import java.util.List;

public class WinningNumbers {
    private Lotto lotto;
    private BonusNumber bonusNumber;

    public WinningNumbers(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> lottoEqualCount(Lottos lottos) {
        return lottos.equalNumbersCount(this.lotto);
    }

    public List<Boolean> bonusNumberEqual(Lottos lottos) {
        return lottos.equalBonusNumber(this.bonusNumber);
    }
}
