package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResultManager {
    private Map<LottoResult, Integer> resultMap;

    LottoResultManager(){
        initialize();
    }
    private void initialize(){
        resultMap = new HashMap<>();
        for(LottoResult result : LottoResult.values()){
            resultMap.put(result, 0);
        }
    }
    public Integer add(LottoResult lottoResult){
        return resultMap.put(lottoResult, resultMap.get(lottoResult) + 1);
    }

}
