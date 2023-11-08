package lotto.domain;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    FAIL(0, false, 0);

    private final int correctCount;
    private final boolean bonusMatch;
    private final int prizeMoney;

    Prize(int correctCount, boolean bonusMatch, int prizeMoney) {
        this.correctCount = correctCount;
        this.bonusMatch = bonusMatch;
        this.prizeMoney = prizeMoney;
    }

    public static Prize judgeRank(int correctCount, boolean bonusMatch) {
        for (Prize prize : Prize.values()) {
            if (prize.correctCount == correctCount && (!prize.bonusMatch || bonusMatch)) {
                return prize;
            }
        }
        return FAIL;
    }

    public int getPrizeMoney() {
        return this.prizeMoney;
    }
}
