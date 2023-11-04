package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, String bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }
}
