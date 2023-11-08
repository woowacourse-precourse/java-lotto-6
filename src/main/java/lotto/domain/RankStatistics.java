package lotto.domain;

import lotto.GameUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankStatistics {
    private static final String COUNT_DELIMITER = " - ";
    private static final String STATISTICS_DELIMITER = "\n";
    private final Map<Rank, Integer> statistics;

    public RankStatistics(Map<Rank, Integer> statistics) {
        this.statistics = statistics;
    }

    public long getTotalProfit() {
        List<Rank> ranks = List.of(Rank.values());
        return ranks.stream()
                .mapToLong(rank -> rank.getPrize() * statistics.get(rank))
                .sum();
    }

    private String generateMessage(int matchNumber, long prize, int count) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(matchNumber)
                .append("개 일치");
        if (prize == Rank.SECOND_PLACE.getPrize()) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(" (")
                .append(GameUtils.convertToMoney(prize))
                .append(")")
                .append(COUNT_DELIMITER)
                .append(count)
                .append("개");
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        List<Rank> ranks = List.of(Rank.values());
        return ranks.stream()
                .filter(rank -> rank != Rank.NONE)
                .map(rank -> generateMessage(rank.getMatchNumber(), rank.getPrize(), statistics.get(rank)))
                .collect(Collectors.joining(STATISTICS_DELIMITER));
    }
}
