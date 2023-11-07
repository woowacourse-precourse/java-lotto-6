package lotto.lottoGame.rank;

public class MatchValue {
    private int matchCounts;
    private boolean bonusMatch;

    public MatchValue() {
        this.matchCounts = 0;
        this.bonusMatch = false;
    }

    public void addMatchCount() {
        this.matchCounts += 1;
    }

    public void matchBonusNumber() {
        this.bonusMatch = true;
    }

    public int getMatchCounts() {
        return matchCounts;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
