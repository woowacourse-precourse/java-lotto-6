package lotto.domain;

public enum WinningResult {
    MATCH_3(3, "3개 일치 (5,000원)", 5000),
    MATCH_4(4, "4개 일치 (50,000원)", 50000),
    MATCH_5(5, "5개 일치 (1,500,000원)", 1500000),
    MATCH_5_WITH_BONUS(5, "5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    MATCH_6(6, "6개 일치 (2,000,000,000원)", 2000000000);

    private final int matchingCount;
    private final String message;
    private final long prize;

    WinningResult(int matchingCount, String message, long prize) {
        this.matchingCount = matchingCount;
        this.message = message;
        this.prize = prize;
    }

    public String getMessage() {
        return message;
    }

    public long getPrize() {
        return prize;
    }
}



