package lotto.domain;

import lotto.validator.WinningLottoValidator;

public class WinningLotto {
    private static WinningLottoValidator winningLottoValidator = new WinningLottoValidator();

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
        winningLottoValidator.checkRange(bonusLottoNum);
        winningLottoValidator.checkDuplicateWinningNumbers(winLotto, bonusLottoNum);
    }

    public int matchSameNumberNum(Lotto userLotto) {
        return winLotto.matchSameNumberNum(userLotto);
    }

    public boolean isBonusNumContain(Lotto userLotto) {
        return userLotto.hasSameNumber(bonusLottoNum);
    }
}
