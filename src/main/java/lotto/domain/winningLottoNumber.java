package lotto.domain;

import lotto.Lotto;

public class winningLottoNumber {
    private final Lotto lotto;
    private final int bonus;

    public winningLottoNumber(Lotto lotto, int bonus){
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public numberOfWins match(Lotto playerInputNumber){
        int numberOfMatch = playerInputNumber.matchingLottoCount(lotto);
        boolean bonusNumberCheck = playerInputNumber.containNumber(bonus);
        return numberOfWins.valueOf(numberOfMatch, bonusNumberCheck);
    }
}
