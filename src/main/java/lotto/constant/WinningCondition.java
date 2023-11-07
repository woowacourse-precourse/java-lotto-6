package lotto.constant;

public enum WinningCondition {
    SIX_MATCH(PRIZE.SIX_MATCH, DESCRIPTION.SIX_MATCH),
    FIVE_MATCH_WITH_BONUS(PRIZE.FIVE_MATCH_WITH_BONUS, DESCRIPTION.FIVE_MATCH_WITH_BONUS),
    FIVE_MATCH(PRIZE.FIVE_MATCH, DESCRIPTION.FIVE_MATCH),
    FOUR_MATCH(PRIZE.FOUR_MATCH, DESCRIPTION.FOUR_MATCH),
    THREE_MATCH(PRIZE.THREE_MATCH, DESCRIPTION.THREE_MATCH);

    public static class PRIZE {
        public static final int SIX_MATCH = 20000000;
        public static final int FIVE_MATCH_WITH_BONUS = 30000000;
        public static final int FIVE_MATCH = 1500000;
        public static final int FOUR_MATCH = 50000;
        public static final int THREE_MATCH = 5000;
    }

    public static class DESCRIPTION {
        public static final String SIX_MATCH = "6개 일치 (2,000,000,000원)";
        public static final String FIVE_MATCH_WITH_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원)";
        public static final String FIVE_MATCH = "5개 일치 (1,500,000원)";
        public static final String FOUR_MATCH = "4개 일치 (50,000원)";
        public static final String THREE_MATCH = "3개 일치 (5,000원)";
    }

    private int prize;
    private String description;

    WinningCondition(int prize, String description) {
        this.prize = prize;
        this.description = description;
    }

    public int getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
