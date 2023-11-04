package lotto.domain;

import lotto.validator.BonusLottoNumValidator;

import java.util.ArrayList;

public class WinningLotto {
    private static BonusLottoNumValidator bonusLottoNumValidator = new BonusLottoNumValidator();

    private Lotto lotto;
    private int bonusLottoNum;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setBonusLottoNum(int bonusLottoNum) {
        validateBonusLottoNum(lotto, bonusLottoNum);
        this.bonusLottoNum = bonusLottoNum;
    }

    private void validateBonusLottoNum(Lotto lotto, int bonusLottoNum) {
        bonusLottoNumValidator.checkRange(bonusLottoNum);
        bonusLottoNumValidator.checkDuplicateWinningNumbers(lotto, bonusLottoNum);
    }

    public int matchNumberNum(Lotto userLotto) {
        return 0;
    }

    public boolean isBonusNumContain(Lotto userLotto) {
        return true;
    }
}
