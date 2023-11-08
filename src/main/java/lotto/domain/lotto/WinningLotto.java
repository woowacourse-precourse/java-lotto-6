package lotto.domain.lotto;

import lotto.domain.rank.Rank;
import lotto.exception.BonusNumDuplicateException;
import lotto.exception.LottoNumRangeException;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber){
        validateBonusNumRange(bonusNumber);
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        if (lotto.containBonusNum(bonusNumber)) {
            throw new BonusNumDuplicateException();
        }
    }

    private void validateBonusNumRange(int bonusNumber) {
        if (bonusNumber <= 0 || bonusNumber > 45) {
            throw new LottoNumRangeException();
        }
    }

    public Rank matchCnt(Lotto playerNumber) {
        int matchCnt = playerNumber.countSameNum(lotto);
        boolean bonusMatch = playerNumber.containBonusNum(bonusNumber);
        return Rank.of(matchCnt, bonusMatch);
    }

}
