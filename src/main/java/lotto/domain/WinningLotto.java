package lotto.domain;

import static lotto.domain.WinningResult.valueOf;
import static lotto.utils.phrase.ErrorPhrase.*;
import static lotto.utils.system.LottoSystemUtils.*;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusLotto;

    public WinningLotto(Lotto winningLotto, Integer bonusLotto) {
        validateBonusLotto(winningLotto, bonusLotto);

        this.winningLotto = winningLotto;
        this.bonusLotto = bonusLotto;
    }

    public WinningResult compare(Lotto lotto) {
        return valueOf(getMatchNumberCnt(lotto), getMatchBonusNumber(lotto));
    }

    private int getMatchNumberCnt(Lotto lotto) {
        return lotto.matchCount(winningLotto);
    }

    private boolean getMatchBonusNumber(Lotto lotto) {
        return lotto.contain(bonusLotto);
    }

    private void validateBonusLotto(Lotto winningLotto, Integer bonusLotto) {
        isRightLottoRange(bonusLotto);
        isDuplicateWinningLotto(winningLotto, bonusLotto);
    }

    private void isRightLottoRange(Integer bonusLotto) {
        if (bonusLotto < LOTTO_NUMBER_MIN_RANGE || bonusLotto > LOTTO_NUMBER_MAX_RANGE) {
            throw new IllegalArgumentException(ERROR_PHRASE_LOTTO_NUMBER_IS_OUT_OF_RANGE);
        }
    }

    private void isDuplicateWinningLotto(Lotto winningLotto, int bonusLotto) {
        if (winningLotto.contain(bonusLotto)) {
            throw new IllegalArgumentException(ERROR_PHRASE_BONUS_LOTTO_NUMBER_IS_DUPLICATED);
        }
    }
}
