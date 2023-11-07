package lotto.model;

public enum LottoPrize {
    THREE_MATCH(3, 5_000) {
        @Override
        public String getDescription() {
            return "3개 일치";
        }
    },
    FOUR_MATCH(4, 50_000) {
        @Override
        public String getDescription() {
            return "4개 일치";
        }
    },
    FIVE_MATCH(5, 1_500_000) {
        @Override
        public String getDescription() {
            return "5개 일치";
        }
    },
    FIVE_AND_BONUS_MATCH(-1, 30_000_000) {
        @Override
        public String getDescription() {
            return "5개 일치, 보너스 볼 일치";
        }
    },
    SIX_MATCH(6, 2_000_000_000) {
        @Override
        public String getDescription() {
            return "6개 일치";
        }
    };

    private final int matchCount;
    private final long prize;

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    LottoPrize(int matchCount, long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public abstract String getDescription();

    public static LottoPrize valueOf(int matchCount) {
        for (LottoPrize prize : values()) {
            if (prize.getMatchCount() == matchCount) {
                return prize;
            }
        }
        return null;
    }
}