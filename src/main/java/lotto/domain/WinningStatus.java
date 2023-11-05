package lotto.domain;

public enum WinningStatus {
    MATCH3(5000, 3),
    MATCH4(50000, 4),
    MATCH5(1500000, 5),
    MATCH5_WITH_BONUS(30000000, 8), //임의의 숫자 초기화
    MATCH6(2000000000, 6);

    private final int prize;
    private final int matchCount;

    WinningStatus(int prize, int matchCount) {
        this.prize = prize;
        this.matchCount = matchCount;
    }

    public int getPrize() {
        return this.prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public static WinningStatus valueOfMatchCount(int matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch == true) {
            return MATCH5_WITH_BONUS;
        }

        for (WinningStatus status : values()) {
            if (status.getMatchCount() == matchCount) {
                return status;
            }
        }

        return null;
    }
}
