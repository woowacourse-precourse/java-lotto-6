package domain;

import java.util.EnumMap;
import java.util.Map;

import static domain.WinningLotto.getMatchCounts;

public class Result {
    private final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);

    public Result(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos.get()) {
            Rank rank = getMatchCounts(lotto, winningLotto);
            rankCount.put(rank, 1);
        }
    }

    public int getRankCount(Rank rank) {
        return rankCount.getOrDefault(rank, 0);
    }

    public int getReward() {
        int reward = 0;
        for (Rank rank : rankCount.keySet()) {
            reward += rank.getReward() * rankCount.get(rank);
        }
        return reward;
    }

}
