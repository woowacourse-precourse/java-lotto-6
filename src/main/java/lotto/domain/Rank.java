package lotto.domain;

import java.util.stream.Stream;

public enum Rank {
    FIRST(2_000_000_000, null, 6), SECOND(30_000_000, Boolean.TRUE, 5), THIRD(1_500_000, null, 5), FOURTH(50_000, null, 4), FIFTH(5_000, null, 3), NON(0, null, 0);
    private final Boolean matchBonusNumber;
    private final Integer matchCount;
    private final int prizeMoney;

    Rank(int prizeMoney, Boolean matchBonusNumber, Integer matchCount) {
        this.prizeMoney = prizeMoney;
        this.matchBonusNumber = matchBonusNumber;
        this.matchCount = matchCount;
    }

    public static Rank of(Boolean matchBonusNumber, Integer matchCount) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.matchBonusNumber == matchBonusNumber)
                .filter(rank -> rank.matchCount.equals(matchCount))
                .findAny()
                .orElse(NON);
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }
}
