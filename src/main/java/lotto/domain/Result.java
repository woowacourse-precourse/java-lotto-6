package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import lotto.utils.Rank;

public class Result {
    private final Map<Rank, Integer> result;

    public Result() {
        result = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
            .forEach(rank -> result.put(rank, 0));
    }
}
