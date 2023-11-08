package lotto.domain.entity;

public class Score {
    private static final int INIT_ZERO = 0;
    private static final boolean INIT_FALSE = false;
    private int matchCount;
    private boolean bonusMatch;

    public Score() {
        this.matchCount = INIT_ZERO;
        this.bonusMatch = INIT_FALSE;
    }

    public void matchOneNumber() {
        matchCount++;
    }

    public void matchBonus() {
        bonusMatch = true;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
