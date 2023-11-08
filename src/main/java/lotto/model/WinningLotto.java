package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonus;

    public WinningLotto(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public List<Integer> getLottoNums() {
        return lotto.getNumbers();
    }
}
