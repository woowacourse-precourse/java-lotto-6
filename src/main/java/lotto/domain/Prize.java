package lotto.domain;

public enum Prize {
    MATCH_3("3개 일치 (5,000원)", 5000),
    MATCH_4("4개 일치 (50,000원)", 50000),
    MATCH_5("5개 일치 (1,500,000원)", 1500000),
    MATCH_5_PLUS_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    MATCH_6("6개 일치 (2,000,000,000원)", 2000000000);

    private final String description;
    private final int prizeAmount;

    Prize(String description, int prizeAmount) {
        this.description = description;
        this.prizeAmount = prizeAmount;
    }

    public String getDescription() {
        return description;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}