package lotto.domain.lotto;

public enum LottoRank {
    LOSING(0, 0),
    FIFTH(5, 5000),
    FOURTH(4, 50000),
    THIRD(3, 1500000),
    SECOND(2, 30000000),
    FIRST(1, 2000000000);

    private final int lottoRankIndex;
    private final int lottoRankPrize;

    LottoRank(int lottoRankIndex, int lottoRankPrize) {
        this.lottoRankIndex = lottoRankIndex;
        this.lottoRankPrize = lottoRankPrize;
    }

    public int getLottoRankIndex() {
        return lottoRankIndex;
    }

    public int getLottoRankPrize() {
        return lottoRankPrize;
    }
}

