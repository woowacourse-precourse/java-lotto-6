package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(String winningNumber, String bonus) {
        return new WinningLotto(new Lotto(winningNumber), LottoNumber.from(bonus));
    }

    public boolean hasTargetLottoNumber(LottoNumber target) {
        return winningLotto.getNumbers().contains(target);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
