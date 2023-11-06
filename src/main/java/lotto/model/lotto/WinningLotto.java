package lotto.model.lotto;

import static lotto.exception.ExceptionMessage.BONUS_NUMBER_DUPLICATION;

public class WinningLotto {

    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
}
