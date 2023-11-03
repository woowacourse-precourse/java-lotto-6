package lotto.domain.config;

public enum ScoreConfig {
    FIRST(6, 0),
    SECOND(5, 1),
    THIRD(5, 0),
    FORTH(4, 0),
    FIFTH(3, 0),
    NOTHING(0, 0),
    ;

    private final int matchCount;
    private final int bonusMatch;

    ScoreConfig(int matchCount, int bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public static ScoreConfig valueOf(int count, boolean bonus) {
        for (ScoreConfig value : ScoreConfig.values()) {
            if (value.matches(count, bonus)) {
                return value;
            }
        }
        return NOTHING;
    }

    private boolean matches(int count, boolean bonus) {
        if (this.bonusMatch == 0) {
            return count == this.matchCount;
        }
        return count == this.matchCount && bonus;
    }
}
