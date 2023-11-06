package lotto.domain;

import java.util.Map;

public class Result {
    private Map<LottoRanking, Integer> rankingCount;
    private Float profitMargin;
    public Result(Map<LottoRanking, Integer> rankingCount){
        this.rankingCount = rankingCount;
    }

    private Float calculateProfitMargin(){
        
    }
}
