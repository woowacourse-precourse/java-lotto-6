package lotto.domain;

import lotto.global.constant.LottoRankAndPrize;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static lotto.global.constant.LottoConstant.*;

public class LottoResult {

    private static final int NONE = 0;

    private Map<LottoRankAndPrize, Integer> totalRanks;
    private final int lottoPurchasePrice;
    private int totalPrize = NONE;

    public LottoResult(int lottoPurchasePrice) {
        this.totalRanks = new HashMap<>();
        this.lottoPurchasePrice = lottoPurchasePrice;
    }

    public void accumulateLottoResult(LottoRankAndPrize lottoRankAndPrize){
        if(totalRanks.containsKey(lottoRankAndPrize)){
            totalRanks.put(lottoRankAndPrize, totalRanks.get(lottoRankAndPrize) + 1);
            return;
        }
        totalRanks.put(lottoRankAndPrize, 1);
    }

    public int getLottoPurchasePrice() {
        return lottoPurchasePrice;
    }

    public int calculateTotalPrize(){
        return 0;
    }

    public int getTotalPrizeAmount() {
        return totalPrize;
    }
}
