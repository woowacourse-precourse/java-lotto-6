package lotto.domain;

import lotto.Lotto;

public class WinningResult {

    private final Lotto lotto;
    private final int bonusNum;

    public WinningResult(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonusNum = bonus;
    }

    public Rank match(Lotto playerNum) {
        int matchCnt = playerNum.countMatch(lotto);
        boolean bonusCheck = playerNum.containNumber(bonusNum);
        return Rank.valueOf(matchCnt, bonusCheck);
    }


}
