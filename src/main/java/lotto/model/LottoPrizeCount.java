package lotto.model;

import static java.util.stream.Collectors.toMap;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoPrizeCount {

    public static final int INITIAL_COUNT = 0;

    private final Map<LottoPrize, Integer> prizeCounts;

    private LottoPrizeCount(List<LottoPrize> prizes) {
        this.prizeCounts = new EnumMap<>(LottoPrize.class);
        initializePrizeCounts();
        prizes.forEach(this::add);
    }

    public static LottoPrizeCount from(List<LottoPrize> prizes) {
        return new LottoPrizeCount(prizes);
    }

    private void initializePrizeCounts() {
        prizeCounts.putAll(
                LottoPrize.stream()
                        .collect(toMap(key -> key, value -> INITIAL_COUNT))
        );
    }

    private void add(final LottoPrize prize) {
        prizeCounts.computeIfPresent(prize, (key, count) -> ++count);
    }

    public int getCountOf(final LottoPrize prize) {
        return prizeCounts.get(prize);
    }
}
