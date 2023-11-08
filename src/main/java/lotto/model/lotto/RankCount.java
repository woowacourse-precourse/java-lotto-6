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

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.FAIL) {
                sb.append(rank.name())
                        .append(": ")
                        .append(getCounts(rank))
                        .append(" 개\n");
            }
        }
        return sb.toString();
    }
}
