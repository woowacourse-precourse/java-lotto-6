package lotto.domain;

import lotto.Lotto;
import lotto.domain.enums.Rank;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto playerNumber) {
        int countOfMatch = playerNumber.countMatch(lotto);
        boolean bonusCheck = playerNumber.containNumber(bonusNumber);
        return Rank.valueOf(countOfMatch, bonusCheck);
    }
}
