package lotto.domain.lotto;

import java.util.HashMap;
import java.util.Map;

public enum Rank {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    MISS(0);

    private static final Map<MatchResult, Rank> RANK_MAP = new HashMap<>();

    static {
        RANK_MAP.put(new MatchResult(6, false), FIRST);
        RANK_MAP.put(new MatchResult(5, true), SECOND);
        RANK_MAP.put(new MatchResult(5, false), THIRD);
        RANK_MAP.put(new MatchResult(4, false), FOURTH);
        RANK_MAP.put(new MatchResult(3, false), FIFTH);
    }

    private final long prize;

    Rank(int prize) {
        this.prize = prize;
    }

    public static Rank of(int matchCount, boolean matchBonus) {
        return RANK_MAP.getOrDefault(new MatchResult(matchCount, matchBonus), MISS);
    }

    private static class MatchResult {
        private final int matchCount;
        private final boolean matchBonus;

        public MatchResult(int matchCount, boolean matchBonus) {
            this.matchCount = matchCount;
            this.matchBonus = matchBonus;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof MatchResult matchResult) {
                return matchCount == matchResult.matchCount && matchBonus == matchResult.matchBonus;
            }
            return false;
        }

        @Override
        public int hashCode() {
            if (matchBonus) {
                return matchCount * 2 + 1;
            }
            return matchCount * 2;
        }
    }
}
