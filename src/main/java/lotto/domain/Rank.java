package lotto.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Rank {
    FIRST(null, 6) {
        private final int prizeMoney = 2_000_000_000;
    }, SECOND(Boolean.TRUE, 5) {
        private final int prizeMoney = 30_000_000;
    }, THIRD(null, 5) {
        private final int prizeMoney = 1_500_000;
    }, FOURTH(null, 4) {
        private final int prizeMoney = 50_000;
    }, FIFTH(null, 3) {
        private final int prizeMoney = 5_000;
    };
    private final Boolean matchBonusNumber;
    private final Integer matchCount;
    private Integer prizeMoney;

    Rank(Boolean matchBonusNumber, Integer matchCount) {
        this.matchBonusNumber = matchBonusNumber;
        this.matchCount = matchCount;
    }

    public static Rank of(Boolean matchBonusNumber, Integer matchCount) {
        return Stream.of(Rank.values())
                .filter(rank -> rank.matchBonusNumber.equals(matchBonusNumber))
                .filter(rank -> rank.matchCount.equals(matchCount))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No matching rank found for match count: " + matchCount + ", match bonus: " + matchBonusNumber));
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }
}
