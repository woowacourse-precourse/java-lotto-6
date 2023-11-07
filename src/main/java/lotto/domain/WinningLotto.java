package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final WinningNumber winning;
    private final BonusNumber bonus;

    public WinningLotto(WinningNumber winning, BonusNumber bonus) {
        this.winning = winning;
        this.bonus = bonus;
    }

    public WinningNumber getWinning() {
        return winning;
    }
    public BonusNumber getBonus() {
        return bonus;
    }
}
