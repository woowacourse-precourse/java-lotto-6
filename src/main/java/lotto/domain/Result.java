package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    private static final String COUNT_MESSAGE = " - %d개";
    private static final long ZERO = 0L;
    private final Map<Rank, Long> result;

    public Result() {
        result = new EnumMap<>(Rank.class);

        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, ZERO));
    }

    public void addRank(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public long getTotalProfit() {
        return Arrays.stream(Rank.values())
                .map(this::getProfit)
                .reduce(ZERO, Long::sum);
    }

    public long getProfit(Rank rank) {
        return rank.getRankReward(result.get(rank));
    }

    public List<String> getAllRankStatistics() {
        return Arrays.stream(Rank.values())
                .map(this::getRankStatistics)
                .toList();
    }

    private String getRankStatistics(Rank rank) {
        StringBuilder rankStatistics = new StringBuilder();
        rankStatistics.append(rank.getRankMessage());
        rankStatistics.append(String.format(COUNT_MESSAGE, result.get(rank)));

        return rankStatistics.toString();
    }
}
