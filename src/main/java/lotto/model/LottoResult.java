package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Integer, Integer> lottoResultMap;

    public LottoResult(){
        this.lottoResultMap = new HashMap<>();
        addLottoResult(3);
        addLottoResult(4);
        addLottoResult(5);
        addLottoResult(6);
        addLottoResult(7);
    }

    public void addLottoResult(Integer key){
        lottoResultMap.put(key, lottoResultMap.getOrDefault(key, 0) + 1);
    }

    public Map<Integer, Integer> getLottoResultMap() {
        return lottoResultMap;
    }
}
