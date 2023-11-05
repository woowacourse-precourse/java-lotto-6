package lotto;

import java.util.stream.Stream;

public enum Rank {
    NONE(-1, true, 0), FIFTH(3, false, 5000.0), FOURTH(4, false, 50000.0), THIRD(5, false, 1500000.0), SECOND(5, true, 30000000.0), FIRST(6, false, 2000000000.0);

    private final int hits;
    private final boolean isMatchBonusNumber;
    private final double prize;

    Rank(int hits, boolean isMatchBonusNumber, double prize) {
        this.hits = hits;
        this.isMatchBonusNumber = isMatchBonusNumber;
        this.prize = prize;
    }

    public int getHits() {
        return hits;
    }

    public boolean isMatchBonusNumber() {
        return isMatchBonusNumber;
    }

    public double getPrize() {
        return prize;
    }

    public static Rank findRank(int hits, boolean isMatchBonusNumber) {
        return Stream.of(values())
                .filter(rank -> (rank.hits == hits)
                        && (rank.isMatchBonusNumber == isMatchBonusNumber))
                .findFirst()
                .orElse(NONE);
    }

}
