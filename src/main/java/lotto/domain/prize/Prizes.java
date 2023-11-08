package lotto.domain.prize;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prizes {
    private final List<Prize> values;

    public Prizes(List<Prize> values) {
        this.values = new ArrayList<>(values);
    }

    public Map<Prize, Long> countPrizes() {
        Map<Prize, Long> prizeCounts = values.stream()
                .collect(Collectors.groupingBy(prize -> prize, () ->
                        new EnumMap<>(Prize.class), Collectors.counting()));

        Stream.of(Prize.values()).forEach(prize ->
                prizeCounts.putIfAbsent(prize, 0L));

        return prizeCounts;
    }

    public int sumProfit() {
        return values.stream()
                .mapToInt(Prize::getProfit)
                .sum();
    }
}