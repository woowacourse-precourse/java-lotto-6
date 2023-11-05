package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningDetails {

    private final Map<Rank, Integer> details;

    public WinningDetails() {
        this.details = new HashMap<>();
    }

    public void addRank(Rank rank) {
        details.put(rank, details.getOrDefault(rank, 0) + 1);
    }

    public long getTotalReward() {
        long totalReward = 0;
        for (int matchCount : details.values()) {
            for (Rank rank : Rank.values()) {
                totalReward += rank.getReward() * matchCount;
            }
        }
        return totalReward;
    }

    @Override
    public String toString() {
        List<Rank> ranks = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.comparing(Rank::getReward))
                .toList();

        StringBuilder historyDetails = new StringBuilder();
        for (Rank rank : ranks) {
            historyDetails.append(rank).append(String.format(" - %d개%n", details.getOrDefault(rank, 0)));
        }

        return historyDetails.toString();
    }
}
