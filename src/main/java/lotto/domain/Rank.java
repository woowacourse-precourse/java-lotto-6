package lotto.domain;

import java.util.function.BiFunction;

public enum Rank implements Comparable<Rank> {
    FIRST(6, (count, bonus) -> count == 6, 2000000000L),
    SECOND(5, (count, bonus) -> count == 5 && bonus, 30000000L),
    THIRD(5, (count, bonus) -> count == 5, 1500000L),
    FOURTH(4, (count, bonus) -> count == 4, 50000L),
    FIFTH(3, (count, bonus) -> count == 3, 5000L),
    NONE(0, (count, bonus) -> count == 0, 0L);

    private final int count;
    private final BiFunction<Integer, Boolean, Boolean> rankMatch;

    private final long prize;

    Rank(int count, BiFunction<Integer, Boolean, Boolean> rankMatch, long prize) {

        this.count = count;
        this.rankMatch = rankMatch;
        this.prize = prize;
    }

    public boolean matchRank(int count, boolean bonus) {

        return rankMatch.apply(count, bonus);
    }

    public long showPrizeCountOf(int count) {
        return prize * count;
    }

    public long showPrize() {
        return prize;
    }

    public int showMatchCount() {
        return count;
    }

}
