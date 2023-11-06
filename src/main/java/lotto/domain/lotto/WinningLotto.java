package lotto.domain.lotto;

import lotto.domain.rank.Rank;
import lotto.exception.BonusNumDuplicateException;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;


    private WinningLotto(Lotto lotto, int bonusNumber){
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static void validate(Lotto lotto, int bonusNumber) {
        if (lotto.containBonusNum(bonusNumber)) {
            throw new BonusNumDuplicateException();
        }
    }

    public Rank matchCnt(Lotto playerNumber) {
        int matchCnt = playerNumber.countSameNum(lotto);
        boolean bonusMatch = playerNumber.containBonusNum(bonusNumber);
        return Rank.of(matchCnt, bonusMatch);
    }

}
