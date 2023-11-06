package domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static domain.WinningLotto.getMatchCounts;

public class Result {
    private final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);

    public Result(Lottos lottos, WinningLotto winningLotto) {
        for(Lotto lotto : lottos.get()){
            Rank rank = getMatchCounts(lotto, winningLotto);
            rankCount.put(rank, 1);
        }
    }

    public int getRankCount(Rank rank) {
        return rankCount.getOrDefault(rank, 0);
    }

}
