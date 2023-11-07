package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constant.Rewards;

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

    public Map<Rewards, Integer> getTotalStats(WinningNumber winningNumber, Integer bonus) {
        HashMap<Rewards, Integer> stats = new HashMap<>();
        stats.put(Rewards.LOSE, 0);
        stats.put(Rewards.FIFTH, 0);
        stats.put(Rewards.FOURTH, 0);
        stats.put(Rewards.THIRD, 0);
        stats.put(Rewards.SECOND, 0);
        stats.put(Rewards.FIRST, 0);

        for (Lotto lotto : lottos) {
            Rewards key = lotto.checkReward(winningNumber, bonus);
            Integer before = stats.get(key);
            stats.put(key, before + 1);
        }

        return stats;
    }
}
