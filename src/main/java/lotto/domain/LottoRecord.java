package lotto.domain;

public record LottoRecord(int matchCount, boolean isBonusMatched) {
    public LottoRank getRank() {
        if (matchCount == 6) return LottoRank.FIRST;
        if (matchCount == 5 && isBonusMatched) return LottoRank.SECOND;
        if (matchCount == 5) return LottoRank.THIRD;
        if (matchCount == 4) return LottoRank.FOURTH;
        if (matchCount == 3) return LottoRank.FIFTH;
        return null;
    }

}