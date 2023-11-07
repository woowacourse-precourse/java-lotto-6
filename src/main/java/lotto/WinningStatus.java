package lotto;

public enum WinningStatus {
    NONE(0, 0, false),
    THREE_MATCHES(3, 5000, false),
    FOUR_MATCHES(4, 50000, false),
    FIVE_MATCHES(5, 1500000, false),
    FIVE_PLUS_BONUS(5, 30000000, true),
    SIX_MATCHES(6, 2000000000, false);

    private final int matchCount;
    private final int prizeMoney;
    private final boolean bonusMatch;

    WinningStatus(int matchCount, int prizeMoney, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    // 주어진 매치 수와 보너스 매치 여부에 따라 적절한 WinningStatus를 반환하는 메서드.
    public static WinningStatus valueOf(int matchCount, boolean bonusMatch) {
        for (WinningStatus status : WinningStatus.values()) {
            if (status.matchCount == matchCount && (bonusMatch == status.bonusMatch || status.bonusMatch == false)) {
                return status;
            }
        }
        return NONE;
    }
}