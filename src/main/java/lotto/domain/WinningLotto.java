package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLotto() {
        List<Integer> winningLotto = lotto.getNumbers();
        return Collections.unmodifiableList(winningLotto);
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
