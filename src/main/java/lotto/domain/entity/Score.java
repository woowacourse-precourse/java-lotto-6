package lotto.domain.entity;

public class Score {
    private int matchCount;
    private boolean bonusMatch;

    public Score() {
        this.matchCount = 0;
        this.bonusMatch = false;
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
