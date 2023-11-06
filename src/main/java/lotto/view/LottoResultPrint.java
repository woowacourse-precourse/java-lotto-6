package lotto.view;

import lotto.io.LottoPrizeResult;

import java.util.HashMap;
import java.util.Map;

public class LottoResultPrint {

    private final Map<LottoPrizeResult, Integer> resultMap = new HashMap<>();

    public void addResult(int matchPoint, boolean isBonus){
        LottoPrizeResult result = LottoPrizeResult.getPrizeResult(matchPoint,isBonus);
        resultMap.put(result,resultMap.getOrDefault(result,0) +1);
    }
    public void lottoResultPrint(){
        for(LottoPrizeResult result : LottoPrizeResult.values()){
            int count = resultMap.getOrDefault(result, 0);
            System.out.println(result.getPrizeResultMessage(count));
        }
    }
    public Map<LottoPrizeResult, Integer> getResultMap(){
        return resultMap;
    }

}
