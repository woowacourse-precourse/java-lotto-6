package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResultManager {
    private static final int ZERO_COUNT = 0;
    private Map<LottoResult, Integer> resultMap;

    LottoResultManager() {
        initialize();
    }

    private void initialize() {
        resultMap = new HashMap<>();
        for (LottoResult result : LottoResult.values()) {
            resultMap.put(result, 0);
        }
    }

    public Integer add(LottoResult lottoResult) {
        return resultMap.put(lottoResult, resultMap.get(lottoResult) + 1);
    }

    private long calculateLottoWinnings(){
        long lottoWinnings = 0;
        for (LottoResult lottoResult : resultMap.keySet()) {
            int lottoResultCount = resultMap.get(lottoResult);
            lottoWinnings += lottoResult.getPrice() * lottoResultCount;
        }
        return lottoWinnings;
    }

    private int calculateLottoCount(){
        return resultMap.values()
                .stream()
                .reduce(Integer::sum)
                .orElse(ZERO_COUNT);
    }

    public double calculateRateOfReturn(int roundDecimalDigit) {
        double lottoCount = calculateLottoCount();
        if( lottoCount == ZERO_COUNT ){
            return ZERO_COUNT;
        }
        double lottoTotalBuyPrice = lottoCount * Lotto.PRICE;
        long lottoWinnings = calculateLottoWinnings();

        double percentage = CalculateUtil.calculatePercentage(lottoWinnings, lottoTotalBuyPrice);
        return CalculateUtil.round(percentage, roundDecimalDigit);
    }
}
