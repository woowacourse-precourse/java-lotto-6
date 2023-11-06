package lotto.domain.wrapper;

import lotto.handler.LottoHandler;

import java.util.Map;

import static lotto.handler.ConstantsHandler.*;

public class LottoResult {

    private final Map<LottoHandler, Integer> lottoResult;

    private LottoResult(Map<LottoHandler, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public static LottoResult create(Map<LottoHandler, Integer> lottoResult) {
        return new LottoResult(lottoResult);
    }

    public Map<LottoHandler, Integer> getLottoResult() {
        return lottoResult;
    }

    public double getProfit() {
        int totalPurchaseAmount = totalPurchaseAmount();
        long totalPrize = totalPrize();

        return (double) totalPrize / totalPurchaseAmount * TOTAL_PERCENTAGE;
    }

    private int totalPurchaseAmount() {
        int totalTickts = INIT_INT_VALUE;

        for (int tickets : lottoResult.values()) {
            totalTickts += tickets;
        }

        return totalTickts * UNIT_OF_AMOUNT;
    }

    private long totalPrize() {
        Long totalPrize = INIT_LONG_VALUE;

        for (LottoHandler lottoHandler : LottoHandler.values()) {
            if (lottoHandler == LottoHandler.OTHER) {
                continue;
            }

            totalPrize += lottoHandler.getPrize() * lottoResult.getOrDefault(lottoHandler, DEFAULT_VALUE);
        }

        return totalPrize;
    }
}
