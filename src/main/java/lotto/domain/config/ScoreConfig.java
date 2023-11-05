package lotto.domain.config;

import lotto.domain.valueobject.FormattedNumber;

public enum ScoreConfig {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FORTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NOTHING(0, false, 0),
    ;

    private final int matchCount;
    private final boolean bonusMatch;
    private final int reward;

    ScoreConfig(int matchCount, boolean bonusMatch, int reward) {
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

    public int getReward() {
        return reward;
    }
}
