package lotto.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoCompareResult {
    private Map<Integer, Boolean> resultMap;

    public LottoCompareResult() {
        this.resultMap = new HashMap<>();
    }

    public void addResult(int matchingNumber, boolean bonusMatch) {
        resultMap.put(matchingNumber, bonusMatch);
    }

    public Map<Integer, Boolean> getResultMap() {
        return Collections.unmodifiableMap(resultMap);
    }

}
