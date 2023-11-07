package lotto.domain;

public class LottoMatch {

    private final int matchCount;
    private final boolean bonusMatch;

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
