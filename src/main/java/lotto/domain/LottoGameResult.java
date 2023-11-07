package lotto.domain;

import java.util.HashMap;
import lotto.config.RankConfig;

public class LottoGameResult {

    private static final int COUNT_ZERO = 0;
    private static final int COUNT_ONE = 1;
    private static final int SUM_ZERO = 0;

    private final HashMap<RankConfig, Integer> lottoResult = new HashMap<>();

    public LottoGameResult(){
        lottoResult.put(RankConfig.FIRST, 0);
        lottoResult.put(RankConfig.SECOND, 0);
        lottoResult.put(RankConfig.THIRD, 0);
        lottoResult.put(RankConfig.FOURTH, 0);
        lottoResult.put(RankConfig.FIFTH, 0);
        lottoResult.put(RankConfig.NO_RANK_ZERO, 0);
        lottoResult.put(RankConfig.NO_RANK_ONE, 0);
        lottoResult.put(RankConfig.NO_RANK_TWO, 0);
    }

    public void setLottoResult(RankConfig rank){
        lottoResult.put(rank, lottoResult.getOrDefault(rank, COUNT_ZERO) + COUNT_ONE);
    }

    public HashMap<RankConfig, Integer> getLottoResult(){
        return lottoResult;
    }

    public long getPrizeSum(){
        long sum = SUM_ZERO;
        for(RankConfig rank : lottoResult.keySet()){
            sum += rank.getPrizeAmount() * lottoResult.get(rank);
        }
        return sum;
    }
}
