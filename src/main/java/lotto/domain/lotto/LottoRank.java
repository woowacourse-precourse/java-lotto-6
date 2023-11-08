package lotto.domain.lotto;

public enum LottoRank {
    LOSING(0, "", 0),
    FIFTH(5, "3개 일치 (5,000원) - ", 5000),
    FOURTH(4, "4개 일치 (50,000원) - ", 50000),
    THIRD(3, "5개 일치 (1,500,000원) - ", 1500000),
    SECOND(2, "5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000),
    FIRST(1, "6개 일치 (2,000,000,000원) - ", 200000000);

    private final int lottoRankIndex;
    private final String resultMessage;
    private final int lottoRankPrize;

    LottoRank(int lottoRankIndex, String resultMessage, int lottoRankPrize) {
        this.lottoRankIndex = lottoRankIndex;
        this.resultMessage = resultMessage;
        this.lottoRankPrize = lottoRankPrize;
    }

    public int getLottoRankIndex() {
        return lottoRankIndex;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public int getLottoRankPrize() {
        return lottoRankPrize;
    }
}

