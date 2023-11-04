package lotto;

public enum Prize {
    MATCH_3(3, 5000, "3개 일치 (5,000원)"),
    MATCH_4(4, 50000, "4개 일치 (50,000원)"),
    MATCH_5(5, 1500000, "5개 일치 (1,500,000원)"),
    MATCH_5_BONUS(6, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_6(7, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchingCount;
    private final int amount;
    private final String description;

    Prize(int matchingCount, int amount, String description) {
        this.matchingCount = matchingCount;
        this.amount = amount;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}