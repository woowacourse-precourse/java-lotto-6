package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningResult {
    private static final int PERCENT = 100;
    private static final String JOIN_DELIM = "\n";
    private static final String PROFIT_FORMAT = "총 수익률은 %.1f%%입니다.";
    private final Map<Rank, Integer> values = new EnumMap<>(Rank.class);

    public void addRank(Rank rank) {
        values.put(rank, values.getOrDefault(rank, 0) + 1);
    }

    public Map<Rank, Integer> getValues() {
        return Collections.unmodifiableMap(values);
    }

    public String getFormattedStatistics() {
        return Arrays.stream(Rank.values())
            .filter(r -> !r.equals(Rank.NONE))
            .map(r -> r.getStatisticsFormat().formatted(values.getOrDefault(r, 0)))
            .collect(Collectors.joining(JOIN_DELIM));
    }

    public String getFormattedProfit(Long money) {
        double prize = Arrays.stream(Rank.values())
            .mapToDouble(r -> r.getPrize() * values.getOrDefault(r, 0))
            .sum();
        return PROFIT_FORMAT.formatted(prize / money * PERCENT);
    }
}
