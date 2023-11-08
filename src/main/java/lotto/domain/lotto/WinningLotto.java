package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto lotto, BonusNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto lotto, BonusNumber bonusNumber) {
        return new WinningLotto(lotto, bonusNumber);
    }


    public List<Integer> getLotto() {
        List<Integer> winningLotto = lotto.getNumbers();
        return Collections.unmodifiableList(winningLotto);
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
