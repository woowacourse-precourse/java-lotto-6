package lotto.domain;

import lotto.Lotto;
import lotto.config.Rank;
import lotto.exception.LottoGameException;
import lotto.exception.WinningLottoException;

public record WinningLotto(Lotto lotto, LottoNumber bonusNumber) {

    public WinningLotto {
        validateDuplicateBonusNumber(lotto, bonusNumber);
    }

    private void validateDuplicateBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new LottoGameException(WinningLottoException.DUPLICATE_BONUS_NUMBER);
        }
    }

    public int countMatchingNumbers(Lotto compare) {
        return lotto.countMatchingNumbers(compare);
    }

    public boolean matchesBonusNumber(Lotto compare) {
        return countMatchingNumbers(compare) == Rank.SECOND.matchedCount
                && compare.contains(bonusNumber);
    }
}
