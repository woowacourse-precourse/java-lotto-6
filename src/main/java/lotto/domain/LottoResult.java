package lotto.domain;

import lotto.global.constant.LottoRankAndPrize;
import lotto.manager.LottoManager;
import lotto.utils.LottoReferee;

import java.util.*;

public class LottoResult {

    private static final int NONE = 0;

    private final LottoManager lottoManager = new LottoManager();
    private final List<Lotto> lottos;
    private final Map<LottoRankAndPrize, Integer> totalRanks;
    private final int lottoPurchasePrice;
    private int totalPrize = NONE;

    public LottoResult(int lottoPurchasePrice) {
        this.totalRanks = new HashMap<>();
        this.lottos = new ArrayList<>();
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

    public void accumulateLotto(Lotto lotto){
        lottos.add(lotto);
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
        float profit = (float) calculateProfit();
        return Math.round((profit * 100) / lottoPurchasePrice);
    }

    public int calculateProfit(){
        int totalPrize = calculateTotalPrize();
        int profit = totalPrize - lottoPurchasePrice;
        if(profit < NONE){
            return NONE;
        }
        return profit;
    }

    public void determineAllLottoRank(WinningLotto winningLotto){
        LottoReferee lottoReferee = lottoManager.getLottoReferee();
        for(Lotto lotto : lottos){
            accumulateLottoResult(lottoReferee.determineLottoRank(lotto, winningLotto));
        }
    }

    public List<Lotto> getLottos(){
        return lottos;
    }

    public int getLottoPurchasePrice() {
        return lottoPurchasePrice;
    }

    public Map<LottoRankAndPrize, Integer> getTotalRanks(){
        return totalRanks;
    }
}
