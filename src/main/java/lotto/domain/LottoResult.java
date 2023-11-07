package lotto.domain;

public class LottoResult {
    private final Integer matchCount;
    private final boolean bonusNumberMatch;
    private final LottoRank rank;

    private LottoResult(Integer matchCount, boolean bonusNumberMatch) {
        this.matchCount = matchCount;
        this.bonusNumberMatch = bonusNumberMatch;
        this.rank = getLottoRank(matchCount, bonusNumberMatch);
    }

    public static LottoResult create(Integer matchCount, Boolean bonusNumberMatch) {
        return new LottoResult(matchCount, bonusNumberMatch);
    }

    public LottoRank getRank() {
        return rank;
    }

    public long getLottoPrize() {
        return rank.getPrize();
    }

    private LottoRank getLottoRank(Integer matchCount, boolean bonusNumberMatch) {
        return LottoRank.findLottoRank(matchCount, bonusNumberMatch);
    }
}
