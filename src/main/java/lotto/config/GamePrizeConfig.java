package lotto.config;

public enum GamePrizeConfig {
//    높은 등수 먼저 : correctCount 높은거 먼저, checkBonus true 먼저
    FIRST_PRIZE(6, false, "2,000,000,000원", 2000000000),
    SECOND_PRIZE(5, true, "30,000,000원", 30000000),
    THIRD_PRIZE(5, false, "1,500,000원", 1500000),
    FOURTH_PRIZE(4, false, "50,000원", 50000),
    FIFTH_PRIZE(3, false, "5,000원", 5000);

    private final int correctCount;
    private final boolean checkBonus;
    private final String prizeText;
    private final long prizeMoney;

    GamePrizeConfig(
            int correctCount,
            boolean checkBonus,
            String prizeText,
            long prizeMoney
    ) {
        this.correctCount = correctCount;
        this.checkBonus = checkBonus;
        this.prizeText = prizeText;
        this.prizeMoney = prizeMoney;
    }

    public int getCorrectCount() {
        return this.correctCount;
    }

    public boolean getCheckBonus() {
        return this.checkBonus;
    }

    public String getPrizeText() {
        return this.prizeText;
    }

    public long getPrizeMoney() {
        return this.prizeMoney;
    }
}