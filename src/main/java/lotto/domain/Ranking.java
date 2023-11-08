package lotto.domain;

public enum Ranking {
    FIFTH(3, "3개 일치 (5,000원)", 5_000),
    FOURTH(4, "4개 일치 (50,000원)", 50_000),
    THIRD(5, "5개 일치 (1,500,000원)", 1_500_000),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000),
    FIRST(6, "6개 일치 (2,000,000,000원)", 2_000_000_000);
    
    private final int matchingNumberCount;
    private final String message;
    private final int prizeMoney;
    
    Ranking(int matchingNumberCount, String message, int prizeMoney) {
        this.matchingNumberCount = matchingNumberCount;
        this.message = message;
        this.prizeMoney = prizeMoney;
    }
    
    public long calculatePrizeMoney(int count) {
        return (long) prizeMoney * count;
    }
    
    public int getMatchingNumberCount() {
        return matchingNumberCount;
    }
    
    public String getMessage() {
        return message;
    }
    
    public int getPrizeMoney() {
        return prizeMoney;
    }
}
