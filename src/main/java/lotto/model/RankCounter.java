package lotto.model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankCounter {
    private static final List<Rank> RANKS = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
    private final EnumMap<Rank, Integer> rankCounter = new EnumMap<Rank, Integer>(Rank.class);

    public RankCounter(List<Rank> ranks) {
        for (Rank rank : RANKS) {
            rankCounter.put(rank, 0);
        }
        for (Rank rank : ranks) {
            if (rank == Rank.NOTHING) {
                continue;
            }
            rankCounter.put(rank, rankCounter.get(rank) + 1);
        }
    }

    public Double computeBenefit(Integer numberOfLottos) {
        Long result = 0L;
        for (Rank rank : RANKS) {
            result += rank.computePrice(rankCounter.get(rank));
        }
        return computeEarningRate(result, numberOfLottos * 1000);
    }

    private double computeEarningRate(long winnings, Integer money) {
        double earningRate = (winnings / (double) money) * 100.0;
        earningRate = Math.round(earningRate * 10) / 10.0;
        return earningRate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : RANKS) {
            sb.append(rank)
                    .append(" - ")
                    .append(rankCounter.get(rank)).append("개\n");
        }
        return sb.toString();
    }
}
