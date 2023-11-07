package lotto.model.lottoResultChecker;


import java.util.EnumMap;
import java.util.Map;

public class LottoMatchingData {
    private final Map<LottoRank, Integer> rankCount;

    public LottoMatchingData() {
        this.rankCount = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            this.rankCount.put(rank, 0);
        }
    }

    public void addMatch(LottoRank rank) {
        this.rankCount.put(rank, this.rankCount.get(rank) + 1);
    }

    public Map<LottoRank, Integer> getRankCount() {
        return new EnumMap<>(rankCount);
    }
}