package domain;

import java.util.List;

public class WinningNumbers {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> equalNumbersCount(Lottos lottos) {
        return lottos.equalNumbersCount(this.lotto);
    }

    public List<Boolean> isEqualBonusNumber(Lottos lottos) {
        return lottos.isEqualBonusNumber(this.bonusNumber);
    }
}
