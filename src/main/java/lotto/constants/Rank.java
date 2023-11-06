package lotto;

public enum Rank {
    FAIL(0, 0) {
        @Override
        public Integer calculatePrizeByRank(int rankCount) {
            return prize * rankCount;
        }
    },
    FIFTH(5_000, 3) {
        @Override
        public Integer calculatePrizeByRank(int rankCount) {
            return prize * rankCount;
        }
    },
    FOURTH(50_000, 4) {
        @Override
        public Integer calculatePrizeByRank(int rankCount) {
            return prize * rankCount;
        }
    },
    THIRD(1_500_000, 5) {
        @Override
        public Integer calculatePrizeByRank(int rankCount) {
            return prize * rankCount;
        }
    },
    SECOND(30_000_000, 5) {
        @Override
        public Integer calculatePrizeByRank(int rankCount) {
            return prize * rankCount;
        }
    },
    FIRST(2_000_000_000, 6) {
        @Override
        public Integer calculatePrizeByRank(int rankCount) {
            return prize * rankCount;
        }
    };

    protected final Integer prize;
    private final Integer matchingCount;

    Rank(Integer prize, Integer matchingCount) {
        this.prize = prize;
        this.matchingCount = matchingCount;
    }

    public Integer getPrize() {
        return prize;
    }

    public Integer getMatchingCount() {
        return matchingCount;
    }

    public abstract Integer calculatePrizeByRank(int rankCount);
}