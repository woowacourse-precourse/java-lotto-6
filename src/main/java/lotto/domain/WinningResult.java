package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {

    private static final int INITIAL_VALUE = 0;
    private static final int ADDING_COUNT = 1;
    private final Map<Rank, Integer> result = new EnumMap<>(Rank.class);

    public WinningResult() {
        init();
    }

    public void updateResult(Rank rank) {
        result.put(rank, result.get(rank) + ADDING_COUNT);
    }

    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public int getTotalPrize() {
        return result.keySet().stream()
                .map(rank -> rank.getPrize() * result.get(rank))
                .reduce(Integer::sum)
                .orElse(0);
    }

    private void init() {
        result.put(Rank.FIRST, INITIAL_VALUE);
        result.put(Rank.SECOND, INITIAL_VALUE);
        result.put(Rank.THIRD, INITIAL_VALUE);
        result.put(Rank.FOURTH, INITIAL_VALUE);
        result.put(Rank.FIFTH, INITIAL_VALUE);
        result.put(Rank.NOTHING, INITIAL_VALUE);
    }
}