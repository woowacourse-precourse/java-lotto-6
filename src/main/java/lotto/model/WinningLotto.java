package lotto.model;

import java.util.List;

public class WinningLotto {
    private final List<Integer> lottos;
    private final int bonus;

    public WinningLotto(List<Integer> lottos, int bonus) {
        this.lottos = lottos;
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public List<Integer> getLottos() {
        return lottos;
    }
}
