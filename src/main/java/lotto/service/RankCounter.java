package lotto.service;

import java.util.Arrays;
import java.util.EnumMap;
import lotto.Rank;

public class RankCounter {
    private final EnumMap<Rank, Integer> map;

    public RankCounter() {
        this.map = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> map.put(rank, 0));
    }

    public void increaseCount(final Rank rank) {
        Integer value = map.get(rank);
        map.put(rank, value + 1);
    }

    public EnumMap<Rank, Integer> getCountResult() {
        return map;
    }
}
