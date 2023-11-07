package lotto.domain.lotto;

public enum LottoRank {
    LOSING(0, 0, 0),
    FIFTH(5, 5000, 3),
    FOURTH(4, 50000, 4),
    THIRD(3, 1500000, 5),
    SECOND(2, 30000000, 5),
    FIRST(1, 2000000000, 6);

    private final int lottoRankIndex;
    private final int lottoRankPrize;
    private final int matchNumberCount;

    LottoRank(int lottoRankIndex, int lottoRankPrize, int matchNumberCount) {
        this.lottoRankIndex = lottoRankIndex;
        this.lottoRankPrize = lottoRankPrize;
        this.matchNumberCount = matchNumberCount;
    }

    public int getLottoRankIndex() {
        return lottoRankIndex;
    }

    public int getLottoRankPrize() {
        return lottoRankPrize;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }
}

