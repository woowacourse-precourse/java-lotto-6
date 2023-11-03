package lotto.domain;

public class LottoResult {
    private final Integer matchCount;
    private final Boolean bonusNumberMatch;

    private LottoResult(Integer matchCount, Boolean bonusNumberMatch) {
        this.matchCount = matchCount;
        this.bonusNumberMatch = bonusNumberMatch;
    }

    public static LottoResult create(Integer matchCount, Boolean bonusNumberMatch) {
        return new LottoResult(matchCount, bonusNumberMatch);
    }
}
