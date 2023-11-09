package lotto.core.lottoBall.domain.match;

public class MatchLottoResult {

    private final int matchCount;
    private final boolean bonusMatch;

    public MatchLottoResult(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }
}
