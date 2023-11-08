package lotto.dto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.domain.Rank;

public class WinningStatistics {

    private final Map<Rank, Integer> rankCount = new EnumMap<>(Rank.class);


    private WinningStatistics(List<Rank> winningRanks) {
        initRankCount();
        winningRanks.forEach(rank -> rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1));

    }

    private void initRankCount() {
        for (Rank rank : Rank.values()) {
            rankCount.put(rank, 0);
        }
    }

    public static WinningStatistics from(List<Rank> ranks) {

        return new WinningStatistics(ranks);
    }

    public int showCountOf(Rank rank) {

        return rankCount.getOrDefault(rank, 0);
    }

    public long showRevenue() {

        Long revenue = Arrays.stream(Rank.values())
                             .map(rank -> rank.showPrizeCountOf(showCountOf(rank)))
                             .reduce(0L, Long::sum);

        return revenue;
    }

    public List<Entry<Rank, Integer>> showRankCountsPair() {

        return rankCount.entrySet()
                .stream()
                .collect(Collectors.toList());
    }




}
