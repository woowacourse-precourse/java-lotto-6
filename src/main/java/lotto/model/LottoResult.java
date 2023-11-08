package lotto.model;

import java.util.HashMap;
import java.util.List;

public class LottoResult {

    public static LottoResult createLottoResult() {
        return new LottoResult();
    }

    public HashMap<LottoRankings, Integer> checkResult(List<LottoRankings> results) {
        HashMap<LottoRankings, Integer> drawResult = new HashMap<>();
        for (LottoRankings result : results) {
            if (drawResult.containsKey(result)) {
                drawResult.put(result, drawResult.get(result) + 1);
                continue;
            }
            drawResult.put(result, 1);
        }
        return drawResult;
    }
}
