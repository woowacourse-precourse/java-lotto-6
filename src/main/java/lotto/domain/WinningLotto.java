package lotto.domain;

import java.util.ArrayList;

public class WinningLotto {
    private Lotto lotto;
    private int bonusLottoNum;

    public WinningLotto(Lotto lotto, int bonusLottoNum) {
        this.lotto = lotto;
        this.bonusLottoNum = bonusLottoNum;
    }

    private void validateBonusLottoNum() {

    }

    public int matchNumberNum(Lotto userLotto) {
        return 0;
    }

    public boolean isBonusNumContain(Lotto userLotto) {
        return true;
    }
}
