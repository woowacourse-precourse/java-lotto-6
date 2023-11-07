package model;

import java.util.EnumMap;

public class RankStatistics {

    private EnumMap<LottoRank, Integer> rankStatistics;

    public void add(LottoRank rank) {
        int rankCount = rankStatistics.getOrDefault(rank, 0);
        rankStatistics.put(rank, rankCount + 1);
    }

}