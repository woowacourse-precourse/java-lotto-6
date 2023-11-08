package lotto.domain;

import lotto.constants.WinningResult;

public class WinLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult compareNumbers(Lotto purchasedLotto) {
        int matchCount = purchasedLotto.countMatchNumber(lotto);
        boolean bonusNumberCheck = purchasedLotto.checkBonusNumber(bonusNumber);
        return WinningResult.setResult(matchCount, bonusNumberCheck);
    }
}