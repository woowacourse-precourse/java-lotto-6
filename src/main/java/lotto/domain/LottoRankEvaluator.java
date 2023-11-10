package lotto.domain;

import static lotto.constants.LottoConstants.INCREASING_UNIT;
import static lotto.constants.LottoConstants.INITIAL_VALUE;

import lotto.constants.RankConstants;
import lotto.dto.WinningLotto;

public class LottoRankEvaluator {
    WinningLotto winningLotto;

    public LottoRankEvaluator(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public RankConstants compareWithWinningLotto(Lotto purchasedLotto) {
        int hitCountOfLottoNumbers = getHitCountOfLottoNumbers(purchasedLotto);
        boolean hasBonusNumber = isHasBonusNumber(purchasedLotto);

        return RankConstants.valueOf(hitCountOfLottoNumbers, hasBonusNumber);
    }

    private boolean isHasBonusNumber(Lotto purchasedLotto) {
        return purchasedLotto.getLottoNumbers().contains(winningLotto.bonusNumber());
    }

    private int getHitCountOfLottoNumbers(Lotto purchasedLotto) {
        int hitCount = INITIAL_VALUE;
        for (int number : winningLotto.winningLottoNumbers()) {
            if (purchasedLotto.getLottoNumbers().contains(number)) {
                hitCount += INCREASING_UNIT;
            }
        }
        return hitCount;
    }
}
