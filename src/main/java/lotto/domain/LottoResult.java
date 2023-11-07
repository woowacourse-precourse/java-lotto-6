package lotto.domain;

import lotto.global.constant.LottoRankAndPrize;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import static lotto.global.constant.LottoConstant.*;

public class LottoResult {

    private static final int NONE = 0;

    private final Map<LottoRankAndPrize, Integer> totalRanks;
    private final int lottoPurchasePrice;
    private int totalPrize = NONE;

    public LottoResult(int lottoPurchasePrice) {
        this.totalRanks = new HashMap<>();
        for(LottoRankAndPrize rankAndPrize : LottoRankAndPrize.values()) {
            totalRanks.put(rankAndPrize, 0);
        }
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

    public Map<LottoRankAndPrize, Integer> getTotalRanks(){
        return totalRanks;
    }

    public int calculateTotalPrize(){
        int totalPrize = 0;

        for (Map.Entry<LottoRankAndPrize, Integer> entry : totalRanks.entrySet()) {
            LottoRankAndPrize rankAndPrize = entry.getKey();
            int count = entry.getValue();
            totalPrize += rankAndPrize.getPrize() * count;
        }
        this.totalPrize = totalPrize;
        return totalPrize;
    }

    public float calculateProfitPercentage(){
        if(totalPrize == NONE){
            return NONE;
        }
        float profit = (float) calculateProfit();
        return Math.round((profit * 100) / lottoPurchasePrice);
    }

    public int calculateProfit(){
        int profit = totalPrize - lottoPurchasePrice;
        if(profit < NONE){
            return NONE;
        }
        return profit;
    }

    public int getTotalPrizeAmount() {
        return totalPrize;
    }
}
