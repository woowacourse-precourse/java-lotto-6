package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos = new ArrayList<>();

    public Lottos() {
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public Integer getTotalReward(WinningNumber winningNumber, Integer bonus) {
        int totalReward = 0;
        for (Lotto lotto : lottos) {
            totalReward += lotto.checkReward(winningNumber, bonus).getValue();
        }
        return totalReward;
    }
}
