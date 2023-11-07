package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000,false),
    SECOND(5, 30_000_000, true){
        @Override
        public boolean match(int matchCount, boolean matchBonus) {
            return super.match(matchCount, matchBonus) && matchBonus;
        }
    },
    THIRD(5, 1_500_000, false){
        @Override
        public boolean match(int matchCount, boolean matchBonus) {
            return super.match(matchCount, matchBonus) && !matchBonus;
        }
    },
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int matchCount;
    private final long winningMoney;
    private final boolean matchBonus;

    Rank(int matchCount, int winningMoney, boolean matchBonus) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
    }

    public static Rank from(int matchCount, boolean matchBonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.match(matchCount, matchBonus))
                .findFirst()
                .orElse(MISS);
    }

    public long getWinningMoney() {
        return winningMoney;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    boolean match(int matchCount, boolean matchBonus) {
        return this.matchCount == matchCount;
    }
}
