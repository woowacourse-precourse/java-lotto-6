package lotto.model.lotto;

import java.util.EnumMap;

public class RankCount {
    private EnumMap<LottoRank, Integer> rankCount;

    public RankCount() {
        this.rankCount = new EnumMap<>(LottoRank.class);
    }

    public void incrementCount(LottoRank rank) {
        this.rankCount.merge(rank, 1, Integer::sum);
    }

    public int getCounts(LottoRank rank) {
        return rankCount.getOrDefault(rank, 0);
    }
}
