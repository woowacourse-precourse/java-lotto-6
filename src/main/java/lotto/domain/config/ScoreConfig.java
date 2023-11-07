package lotto.domain.config;

import lotto.domain.valueobject.FormattedNumber;

public enum ScoreConfig {
    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FORTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    NOTHING(0, false, 0L),
    ;

    private final int matchCount;
    private final boolean bonusMatch;
    private final long reward;

    ScoreConfig(int matchCount, boolean bonusMatch, long reward) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.reward = reward;
    }

    public boolean matches(int count, boolean bonus) {
        if (this.bonusMatch == false) {
            return count == this.matchCount;
        }
        return count == this.matchCount && bonus;
    }

    public static ScoreConfig valueOf(int count, boolean bonus) {
        for (ScoreConfig value : values()) {
            if (value.matches(count, bonus)) {
                return value;
            }
        }
        return NOTHING;
    }

    public FormattedNumber getFormattedReward() {
        return new FormattedNumber(reward);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public long getReward() {
        return reward;
    }
}
