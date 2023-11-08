package lotto;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultManager {
    private static final int ZERO_COUNT = 0;
    private static final int PERCENTAGE_VALUE = 100;
    private static final String RESULT_INFO_MESSAGE = "당첨 통계\n---";
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

    private long calculateLottoWinnings() {
        long lottoWinnings = 0;
        for (LottoResult lottoResult : resultMap.keySet()) {
            int lottoResultCount = resultMap.get(lottoResult);
            lottoWinnings += lottoResult.getPrice() * lottoResultCount;
        }
        return lottoWinnings;
    }

    private int calculateLottoCount() {
        return resultMap.values()
                .stream()
                .reduce(Integer::sum)
                .orElse(ZERO_COUNT);
    }

    public String calculateRateOfReturn() {
        double lottoCount = calculateLottoCount();
        if (lottoCount == ZERO_COUNT) {
            return Integer.toString(ZERO_COUNT);
        }
        double lottoTotalBuyPrice = lottoCount * Lotto.PRICE;
        long lottoWinnings = calculateLottoWinnings();

        BigDecimal winnings = BigDecimal.valueOf(lottoWinnings);
        BigDecimal totalBuyPrice = BigDecimal.valueOf(lottoTotalBuyPrice);
        BigDecimal percentage = BigDecimal.valueOf(PERCENTAGE_VALUE);
        double rateOfReturn = winnings.divide(totalBuyPrice, MathContext.DECIMAL64)
                .multiply(percentage)
                .doubleValue();

        return String.format(LottoStringFormat.LOTTO_RATE_OF_RETURN, rateOfReturn);
    }

    public void printLottoResult() {
        List<LottoResult> lottoResults = Arrays.stream(LottoResult.values())
                .filter(a -> a.getPrice() > 0)
                .sorted((a1, a2) -> Math.toIntExact(a1.getPrice() - a2.getPrice()))
                .toList();

        System.out.println(RESULT_INFO_MESSAGE);
        for (LottoResult lottoResult : lottoResults) {
            LottoRule lottoRule = LottoRule.valueOf(lottoResult.name());
            System.out.printf((LottoStringFormat.LOTTO_RESULT_FORMAT) + "%n", lottoRule, lottoResult,
                    resultMap.get(lottoResult));
        }
        System.out.printf((LottoStringFormat.LOTTO_RATE_OF_RETURN_RESULT) + "%n", calculateRateOfReturn());
    }
}
