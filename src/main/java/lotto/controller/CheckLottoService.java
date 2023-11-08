package lotto.controller;

import lotto.model.DHLottery;
import lotto.model.Lotto;
import lotto.model.ScoreType;

public class CheckLottoService {
    private Integer sameCount;
    private Integer bonusCount;

    public CheckLottoService() {
        this.sameCount = 0;
        this.bonusCount = 0;
    }

    public ScoreType rankLotto() {
        if (sameCount == 6)
            return ScoreType.FIRST;
        if (sameCount == 5 && bonusCount == 1)
            return ScoreType.SECOND;
        if (sameCount == 5)
            return ScoreType.THIRD;
        if (sameCount == 4)
            return ScoreType.FOURTH;
        if (sameCount == 3)
            return ScoreType.FIFTH;
        return ScoreType.NOTHING;
    }

    public void checkLotto(DHLottery dhLottery, Lotto lotto) {
        for (int i = 0; i < 6; i++)
            if (dhLottery.getWinningNumber().contains(lotto.getNumbers().get(i)))
                this.sameCount++;

        if (lotto.getNumbers().contains(dhLottery.getBonusNumber()))
            this.bonusCount++;
    }
}
