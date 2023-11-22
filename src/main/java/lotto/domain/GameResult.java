package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.globar.LottoResultInfo;

public class GameResult {
    Map<LottoResultInfo, Integer> finalResult;
    double rateOfReturn;

    private GameResult() {
    }

    private GameResult(Map<LottoResultInfo, Integer> finalResult, double rateOfReturn) {
        this.finalResult = finalResult;
        this.rateOfReturn = rateOfReturn;
    }

    public static GameResult createGameResult(List<LottoResult> lottoResults, long lottoPurchasePrice) {
        Map<LottoResultInfo, Integer> finalResult = new HashMap<>();
        preprocessFinalResult(finalResult);

        double allPrize = 0;

        for (LottoResult lottoResult : lottoResults) {
            LottoResultInfo lottoResultInfo = lottoResult.lottoResultInfo;
            finalResult.put(lottoResultInfo, finalResult.getOrDefault(lottoResultInfo,0) + 1);
            allPrize += lottoResult.lottoResultInfo.getPrize();
        }

        double rateOfReturn = Math.round((allPrize / lottoPurchasePrice * 1000.0))/ 10.0;
        return new GameResult(finalResult, rateOfReturn);
    }

    public static void preprocessFinalResult(Map<LottoResultInfo, Integer> resultMap) {
        for (LottoResultInfo value : LottoResultInfo.values()) {
            resultMap.put(value, 0);
        }
    }

    public Map<LottoResultInfo, Integer> getFinalResult() {
        // 불변한 성질을 가지게 반환.
        return Collections.unmodifiableMap(finalResult);
    }

    public double getRateOfReturn() {
        // 불변
        return rateOfReturn;
    }
}
