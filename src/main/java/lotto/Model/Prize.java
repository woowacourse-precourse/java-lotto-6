package lotto.Model;

public enum Prize {
    MATCH_3(3, 5000, false),
    MATCH_4(4, 50000, false),
    MATCH_5(5, 1500000, false),
    MATCH_5_BONUS(5, 30000000, true),
    MATCH_6(6, 2000000000, false);

    private final int matchCount;
    private final int reward;
    private final boolean bonusMatch;

    Prize(int matchCount, int reward, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public static Prize valueOf(int matchCount, boolean bonusMatch) {
        for (Prize prize : Prize.values()) {
            if (prize.getMatchCount() == matchCount) {
                if ((prize.isBonusMatch() && bonusMatch) || (!prize.isBonusMatch() && !bonusMatch)) {
                    return prize;
                }
            }
        }
        return null;
    }

}
