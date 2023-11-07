package lotto.model;

import java.util.HashMap;

public class WinnerLotto {
    private int[] lottoPrizeCount = new int[8];

    private HashMap<PrizeMoney,Integer> lottoRankStore = new HashMap<>();

    public HashMap<PrizeMoney, Integer> getLottoRankStore() {
        return lottoRankStore;
    }

    public void setLottoRankStore(HashMap<PrizeMoney, Integer> lottoRankStore) {
        this.lottoRankStore = lottoRankStore;
    }

    public int[] getLottoPrizeCount() {
        return lottoPrizeCount;
    }

    public void setLottoPrizeCount(int[] lottoPrizeCount) {
        this.lottoPrizeCount = lottoPrizeCount;
    }


}
