package lotto.model;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Map;

public enum MatchCount {

    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    NONE(-1);

    private static final Map<Integer, MatchCount> matchCounts = Arrays.stream(values())
            .collect(toMap(
                    MatchCount::getCount,
                    count -> count
            ));

    private final int count;

    MatchCount(final int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public static MatchCount of(final int count) {
        return matchCounts.getOrDefault(count, NONE);
    }
}
