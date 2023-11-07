package lotto.domain;

public enum Ranking {
    FIFTH(3, "3개 일치 (5,000원)", 5_000, 0),
    FOURTH(4, "4개 일치 (50,000원)", 50_000, 0),
    THIRD(5, "5개 일치 (1,500,000원)", 1_500_000, 0),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000, 0),
    FIRST(6, "6개 일치 (2,000,000,000원)", 2_000_000_000, 0);
    
    private final int matchNumberCount;
    private final String message;
    private final int prizeMoney;
    private int count;
    
    Ranking(int matchNumberCount, String message, int prizeMoney, int count) {
        this.matchNumberCount = matchNumberCount;
        this.message = message;
        this.prizeMoney = prizeMoney;
        this.count = count;
    }
    
    public int getMatchNumberCount() {
        return matchNumberCount;
    }
    
    public void addCount() {
        count++;
    }
    
    public int getCount() {
        return count;
    }
    
    public String getMessage() {
        return message;
    }
}
