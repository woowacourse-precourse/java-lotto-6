package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningDetails {

    private static final int INITIAL_COUNT = 0;

    private final Map<Rank, Integer> details;

    public WinningDetails() {
        this.details = new HashMap<>();
    }

    public void addRank(Rank rank) {
        details.put(rank, getCount(rank) + 1);
    }

    private Integer getCount(Rank rank) {
        return details.getOrDefault(rank, INITIAL_COUNT);
    }

    public long getTotalReward() {
        long totalReward = 0;
        for (Rank rank : details.keySet()) {
            totalReward += rank.getReward() * getCount(rank);
        }
        return totalReward;
    }

    @Override
    public String toString() {
        StringBuilder winningDetails = new StringBuilder();
        for (Rank rank : getRanksWithoutMiss()) {
            winningDetails.append(rank).append(String.format(" - %d개%n", getCount(rank)));
        }
        return winningDetails.toString();
    }

    private List<Rank> getRanksWithoutMiss() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.comparing(Rank::getReward))
                .toList();
    }
}
