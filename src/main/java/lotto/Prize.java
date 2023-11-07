package lotto;

public enum Prize {
    FIFTH("3개 일치 (5,000원)", 3, 5_000),
    FOURTH("4개 일치 (50,000원)", 4, 50_000),
    THIRD("5개 일치 (1,500,000원)", 5, 1_500_000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 5, 30_000_000),
    FIRST("6개 일치 (2,000,000,000원)", 6, 2_000_000_000),
    NO_PRIZE("꽝", 0, 0);

    private final String prizeString;
    private final int matchingCount;
    private final int prizeAmount;

    Prize(String prizeString, int matchingCount, int prizeAmount) {
        this.prizeString = prizeString;
        this.matchingCount = matchingCount;
        this.prizeAmount = prizeAmount;
    }

    public String getPrizeString() {
        return prizeString;
    }
}
