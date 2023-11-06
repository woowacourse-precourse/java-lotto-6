package lotto.domain;

import java.util.List;
import lotto.Lotto;

public class WinningNumber {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumber(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }


}
