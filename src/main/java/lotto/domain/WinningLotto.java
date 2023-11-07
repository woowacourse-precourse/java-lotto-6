package lotto.domain;

import lotto.validator.LottoNumbersValidator;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        LottoNumbersValidator.validateBonus(winningLotto.getNumbers(), bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLotto.getNumbers();
    }

}


