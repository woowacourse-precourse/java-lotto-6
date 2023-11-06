package lotto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.StringJoiner;

public class Result {
    private final Map<Rank, Long> result;

    public Result() {
        result = new EnumMap<>(Rank.class);

        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, 0L));
    }

    public void addRank(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public long getTotalProfit() {
        return Arrays.stream(Rank.values())
                .map(this::getProfit)
                .reduce(0L, Long::sum);
    }

    public long getProfit(Rank rank) {
        return rank.getRankReward(result.get(rank));
    }

    public String getRankStatistics(Rank rank) {
        StringJoiner stringJoiner = new StringJoiner(" ");
        stringJoiner.add(rank.getRankMessage());
        stringJoiner.add("-");
        stringJoiner.add(String.format("%s개", result.get(rank)));

        return stringJoiner.toString();
    }
}
