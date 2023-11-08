package lotto.domain;

public enum Prize {

    THREE_MATCH(1, "3개 일치 (5,000원) - ", 5000),
    FOUR_MATCH(2, "4개 일치 (50,000원) - ", 50000),
    FIVE_MATCH(3, "5개 일치 (1,500,000원) - ", 1500000),
    FIVE_MATCH_BONUS(4, "5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000),
    SIX_MATCH(5, "6개 일치 (2,000,000,000원) - ",2000000000);

    private final int rank;
    private final String description;
    private final int prizeAmount;

    Prize(int rank, String description, int prizeAmount) {
        this.rank = rank;
        this.description = description;
        this.prizeAmount = prizeAmount;
    }

    public int getRank() {
        return rank;
    }

    public String getDescription() {
        return description;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}
