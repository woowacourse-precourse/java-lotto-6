package lotto.model;

import java.util.List;

public class WinningLotto{
    private final Lotto lotto;
    private final Bonus bonus;

    public WinningLotto(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }
}
