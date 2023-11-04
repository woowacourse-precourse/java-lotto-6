package lotto.domain;

import java.util.ArrayList;

public class WinningLotto {
    Lotto lotto;
    BonusLottoNum bonusLottoNum;

    public WinningLotto(Lotto lotto, BonusLottoNum bonusLottoNum) {
        this.lotto = lotto;
        this.bonusLottoNum = bonusLottoNum;
    }

    public int matchNumberNum(Lotto userLotto) {
        return 0;
    }

    public boolean isBonusNumContain(Lotto userLotto) {
        return true;
    }
}
