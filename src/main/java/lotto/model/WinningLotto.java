package lotto.model;

import java.util.List;
import lotto.validator.BonusNumberValidator;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> winningLotto, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        BonusNumberValidator.validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLotto.getNumbers();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
