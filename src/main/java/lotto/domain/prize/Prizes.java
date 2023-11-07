package lotto.domain.prize;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prizes {
    private final List<Prize> values;

    public Prizes(List<Prize> values) {
        this.values = new ArrayList<>(values);
    }

    public Map<Prize, Long> countPrizes() {
        return values.stream()
                .collect(Collectors.groupingBy(prize -> prize, () ->
                        new EnumMap<>(Prize.class), Collectors.counting()));
    }

    public int sumProfit() {
        return values.stream()
                .mapToInt(Prize::getProfit)
                .sum();
    }
}