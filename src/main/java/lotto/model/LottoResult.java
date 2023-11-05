package lotto.model;

public class LottoResult {

    private final LottoRank lottoRank;
    private final int count;

    public LottoResult(LottoRank lottoRank, int count) {
        this.lottoRank = lottoRank;
        this.count = count;
    }

    public int getSameEa(){
        return this.count;
    }

    public int getReward() {
        return this.lottoRank.getReward();
    }

    public int getMatchCount() {
        return this.lottoRank.getCount();
    }

    public Boolean isLottoThirdRank() {
        return this.lottoRank == LottoRank.THIRD_RANK;
    }


}
