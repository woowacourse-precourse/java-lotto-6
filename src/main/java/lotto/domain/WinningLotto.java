package lotto.domain;

import lotto.validator.WinningLottoValidator;

public class WinningLotto {
    private Lotto winLotto;
    private int bonusLottoNum;

    public WinningLotto(Lotto winLotto) {
        this.winLotto = winLotto;
    }

    public void setBonusLottoNum(int bonusLottoNum) {
        validateBonusLottoNum(winLotto, bonusLottoNum);
        this.bonusLottoNum = bonusLottoNum;
    }

    private void validateBonusLottoNum(Lotto winLotto, int bonusLottoNum) {
        WinningLottoValidator winningLottoValidator = new WinningLottoValidator();
        winningLottoValidator.checkRange(bonusLottoNum);
        winningLottoValidator.checkDuplicateWinningNumbers(winLotto, bonusLottoNum);
    }

    public int matchSameNumberCount(Lotto userLotto) {
        return winLotto.matchSameNumberCount(userLotto);
    }

    public boolean isBonusNumContain(Lotto userLotto) {
        return userLotto.hasSameNumber(bonusLottoNum);
    }
}
