package lotto.domain;

import lotto.utils.LottoNumbersValidator;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public void setWinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        LottoNumbersValidator.validateRange(bonusNumber);
        LottoNumbersValidator.validateDuplicateBonusNumber(winningLotto.getNumbers(), bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}