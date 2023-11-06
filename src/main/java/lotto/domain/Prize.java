package lotto.domain;

public enum Prize {
    THREE_MATCH(3, "3개 일치 (5,000원)", 5000),
    FOUR_MATCH(4, "4개 일치 (50,000원)", 50000),
    FIVE_MATCH(5, "5개 일치 (1,500,000원)", 1500000),
    FIVE_MATCH_WITH_BONUS(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    SIX_MATCH(6, "6개 일치 (2,000,000,000원)", 2000000000);

    private final int matchingNumbers;
    private final String prizeName;
    private final int prizeAmount;

    Prize(int matchingNumbers, String prizeName, int prizeAmount) {
        this.matchingNumbers = matchingNumbers;
        this.prizeName = prizeName;
        this.prizeAmount = prizeAmount;
    }

    public int getMatchingNumbers() {
        return matchingNumbers;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }
}

