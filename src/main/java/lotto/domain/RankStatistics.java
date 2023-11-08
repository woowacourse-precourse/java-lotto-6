package lotto.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankStatistics {
    private List<RankInfo> rankInfos;

    private Double profitRate;

    public RankStatistics(List<Rank> ranks, Integer purchaseAmount) {
        this.rankInfos = getRankInfos(ranks);
        this.profitRate = (double) getTotalPrize() / purchaseAmount;
    }

    private List<RankInfo> getRankInfos(List<Rank> ranks) {
        Map<Rank, RankInfo> rankInfoMap = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankInfoMap.put(rank, new RankInfo(rank, 0, rank.getPrize()));
        }

        for (Rank rank : ranks) {
            if (rank != null) {
                RankInfo rankInfo = rankInfoMap.get(rank);
                rankInfo.incrementCount();
                rankInfo.addPrize(rank.getPrize());
                rankInfoMap.put(rank, rankInfo);
            }
        }

        return rankInfoMap.values().stream()
                .sorted(Comparator.comparingInt(rankInfo -> rankInfo.getRank().getMatchBallCount()))
                .collect(Collectors.toList());
    }


    private long getTotalPrize() {
        return rankInfos.stream()
                .mapToLong(RankInfo::getPrize)
                .sum();
    }

    public List<RankInfo> getRankInfos() {
        return rankInfos;
    }

    public Double getProfitRate() {
        return profitRate;
    }
}
