package lotto.domain;

public enum Prize {
    FIFTH(3, 5_000, "3개 일치 (5,000원) - %d개"),
    FORTH(4, 50_000, "4개 일치 (50,000원) - %d개"),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - %d개"),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - %d개");

    private final int matchCount;
    private final long reward;
    private final String message;

    public static Prize findPrize(int matchCount, boolean isBonusMatch) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }
        if (matchCount == SECOND.matchCount && isBonusMatch) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount && !isBonusMatch) {
            return THIRD;
        }
        if (matchCount == FORTH.matchCount) {
            return FORTH;
        }
        if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        return null;
    }

    public String getMessage() {
        return message;
    }

    public long getReward() {
        return reward;
    }

    private Prize(int matchCount, long reward, String message) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.message = message;
    }
}
