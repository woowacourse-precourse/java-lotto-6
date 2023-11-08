package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.globar.LottoResultInfo;

public class GameResult {
    Map<LottoResultInfo, Integer> resultMap;
    double rateOfReturn;


    private GameResult() {
    }

    private GameResult(Map<LottoResultInfo, Integer> resultMap, double rateOfReturn) {
        this.resultMap = resultMap;
        this.rateOfReturn = rateOfReturn;
    }

    public static GameResult createGameResult(List<LottoResult> lottoResults, long lottoPurchasePrice) {
        Map<LottoResultInfo, Integer> resultMap = new HashMap<>();
        double allPrize = 0;

        for (LottoResultInfo value : LottoResultInfo.values()) {
            resultMap.put(value, 0);
        }

        for (LottoResult lottoResult : lottoResults) {
            LottoResultInfo lottoResultInfo = lottoResult.lottoResultInfo;

            resultMap.put(lottoResultInfo, resultMap.getOrDefault(lottoResultInfo,0) + 1);
            allPrize += lottoResult.lottoResultInfo.getPrize();
        }

        //BigDecimal
        double rateOfReturn = Math.round((allPrize / lottoPurchasePrice * 100) * 10.0)/ 10.0;
        return new GameResult(resultMap, rateOfReturn);
    }

    public Map<LottoResultInfo, Integer> getResultMap() {
            return resultMap;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
