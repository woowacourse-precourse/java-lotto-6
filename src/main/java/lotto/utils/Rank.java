package lotto.utils;

public enum Rank {
    FIRST(6, 2000000000) {
        @Override
        public boolean matches(int matchCount, boolean hasBonus) {
            return matchCount == 6;
        }
    },
    SECOND(5, 30000000) {
        @Override
        public boolean matches(int matchCount, boolean hasBonus) {
            return matchCount == 5 && hasBonus;
        }
    },
    THIRD(5, 1500000) {
        @Override
        public boolean matches(int matchCount, boolean hasBonus) {
            return matchCount == 5 && !hasBonus;
        }
    },
    FOURTH(4, 50000) {
        @Override
        public boolean matches(int matchCount, boolean hasBonus) {
            return matchCount == 4;
        }
    },
    FIFTH(3, 5000) {
        @Override
        public boolean matches(int matchCount, boolean hasBonus) {
            return matchCount == 3;
        }
    },
    NONE(0, 0) {
        @Override
        public boolean matches(int matchCount, boolean hasBonus) {
            return matchCount < 3;
        }
    };

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public abstract boolean matches(int matchCount, boolean hasBonus);

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank findRank(int matchCount, boolean hasBonus) {
        for (Rank rank : values()) {
            if (rank.matches(matchCount, hasBonus)) {
                return rank;
            }
        }
        return NONE;
    }
}
