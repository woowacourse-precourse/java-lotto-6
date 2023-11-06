package lotto.model;

/**
 *  @Class  : 로또 당첨 결과 개수 클래스
 */
public class LottoResult {

    private final LottoRank lottoRank;
    private final int count;

    public LottoResult(LottoRank lottoRank, int count) {
        this.lottoRank = lottoRank;
        this.count = count;
    }

    public int getSameEa() {
        return this.count;
    }

    public int getReward() {
        return this.lottoRank.getReward();
    }

    public int getMatchCount() {
        return this.lottoRank.getCount();
    }

    public Boolean isLottoSecondRank() {
        return this.lottoRank == LottoRank.SECOND_RANK;
    }

    public int getTotalReward() {
        return getReward() * count;
    }

}
