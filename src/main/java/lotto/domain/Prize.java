package lotto.domain;

public enum Prize {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    BLANK(-1, false, 0);

    private final int correctNumber;
    private final boolean needCorrectBonus;
    private final long reward;

    Prize(int correctNumber, boolean needCorrectBonus, long reward) {
        this.correctNumber = correctNumber;
        this.needCorrectBonus = needCorrectBonus;
        this.reward = reward;
    }

    public static Prize earnPrize(MatchResult result) {
        for (Prize prize : Prize.values()) {
            if (prize.correctNumber > result.correctNumber()) {
                continue;
            }
            if (prize.needCorrectBonus && !result.correctBonusNumber()) {
                continue;
            }
            return prize;
        }
        return BLANK;
    }
}
