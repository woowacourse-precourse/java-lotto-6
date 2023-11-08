package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WinReward {

    private final Map<Rank, Integer> details;

    public WinReward() {
        this.details = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values()).forEach(rank -> details.put(rank, INITIAL_COUNT));
    }

    public void addRank(Rank rank) {
        details.merge(rank, 1, Integer::sum);
    }

    public long getTotalReward() {
        return details.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        return details.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.MISS)
                .sorted(Map.Entry.<Rank, Integer>comparingByKey().reversed())
                .map(entry -> String.format("%s - %d개%n", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining());
    }
}