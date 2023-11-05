package lotto.domain;

public class LottoMatch {

    private int matchCount;
    private boolean bonusMatch;

    public LottoMatch(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getBonusMatch() {
        return bonusMatch;
    }
}
