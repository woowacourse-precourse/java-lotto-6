package lotto.model;

import java.util.List;

public class WinningLotto {
    private final List<Integer> lotto;
    private final int bonus;

    public WinningLotto(List<Integer> lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
