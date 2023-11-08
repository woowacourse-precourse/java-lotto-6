package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankStatistics {
    private List<RankInfo> rankInfos;

    private Double profitRate;

    public RankStatistics(List<Rank> ranks) {
        this.rankInfos = getRankInfos(ranks);
    }

    private List<RankInfo> getRankInfos(List<Rank> ranks) {
        Map<Rank, RankInfo> rankInfoMap = new HashMap<>();

        for (Rank rank : ranks) {
            if (rank != null) {
                RankInfo rankInfo = rankInfoMap.get(rank);
                if (rankInfo == null) {
                    rankInfo = new RankInfo(rank, 1, rank.getPrize());
                } else {
                    rankInfo.incrementCount();
                    rankInfo.addPrize(rank.getPrize());
                }
                rankInfoMap.put(rank, rankInfo);
            }
        }

        return new ArrayList<>(rankInfoMap.values());
    }

    private long getTotalPrize(List<Rank> ranks) {
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
