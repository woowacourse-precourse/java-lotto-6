package lotto.model;

import java.util.HashMap;
import java.util.List;

public class LottoResult {

    private HashMap<LottoRankings, Integer> lottoResult;

    public void checkResult(List<LottoRankings> results) {
        HashMap<LottoRankings, Integer> hashMap = new HashMap<>();
        for (LottoRankings result : results) {
            if (hashMap.containsKey(result)) {
                hashMap.put(result, hashMap.get(result) + 1);
                continue;
            }
            hashMap.put(result, 1);
        }
        this.lottoResult = hashMap;
    }

    public HashMap<LottoRankings, Integer> getLottoResult() {
        return lottoResult;
    }
}
