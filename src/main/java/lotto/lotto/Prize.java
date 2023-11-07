package lotto.lotto;

public enum Prize {
    MATCH_3(3, 5_000, "3개 일치 (5,000원)"),
    MATCH_4(4, 50_000, "4개 일치 (50,000원)"),
    MATCH_5(5, 1_500_000, "5개 일치 (1,500,000원)"),
    MATCH_5_BONUS(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    MATCH_6(6, 2_000_000_000, "6개 일치 (2,000,000,000원)"),
    NOTING(0, 0, "미당첨");

    private final int matchCount;
    private final int prizeMoney;
    private final String description;

    Prize(int matchCount, int prizeMoney, String description) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }

    public static Prize valueOf(Long matchCount, boolean isBonusMatch) {
        if (matchCount == 5 && isBonusMatch) {
            return MATCH_5_BONUS;
        }
        if (matchCount == 5) {
            return MATCH_5;
        }
        for (Prize prize : Prize.values()) {
            if (matchCount == prize.matchCount) {
                return prize;
            }
        }
        return NOTING;
    }
}

