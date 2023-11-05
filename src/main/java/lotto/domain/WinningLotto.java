package lotto.domain;

import lotto.validator.WinningLottoValidator;

public class WinningLotto {
    private static WinningLottoValidator winningLottoValidator = new WinningLottoValidator();

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
        winningLottoValidator.checkRange(bonusLottoNum);
        winningLottoValidator.checkDuplicateWinningNumbers(lotto, bonusLottoNum);
    }

    public int matchNumberNum(Lotto userLotto) {
        return 0;
    }

    public boolean isBonusNumContain(Lotto userLotto) {
        return true;
    }
}
