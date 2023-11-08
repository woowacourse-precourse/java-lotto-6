package lotto.service;

import lotto.constants.LottoRankConstants;
import lotto.dto.Lotto;
import lotto.dto.WinningLotto;

public class Comparator {
    WinningLotto winningLotto;

    public Comparator(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public LottoRankConstants compareWithWinningLotto(Lotto purchasedLotto) {
        int hitCountOfLottoNumbers = getHitCountOfLottoNumbers(purchasedLotto);
        boolean hasBonusNumber = isHasBonusNumber(purchasedLotto);

        return LottoRankConstants.valueOf(hitCountOfLottoNumbers, hasBonusNumber);
    }

    private boolean isHasBonusNumber(Lotto purchasedLotto) {
        return purchasedLotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    private int getHitCountOfLottoNumbers(Lotto purchasedLotto) {
        int hitCount = 0;
        for (int number : winningLotto.getWinningLottoNumbers()) {
            if (purchasedLotto.getNumbers().contains(number)) {
                hitCount += 1;
            }
        }
        return hitCount;
    }
}
