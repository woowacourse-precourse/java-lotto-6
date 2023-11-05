package lotto.domain.wrapper;

import lotto.handler.LottoHandler;

import java.util.Map;

import static lotto.handler.ConstantsHandler.UNIT_OF_AMOUNT;

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

    public float getProfit() {
        int totalPurchaseAmount = totalPurchaseAmount();
        int totalPrize = totalPrize();

        return (float) totalPrize / totalPurchaseAmount * 100;
    }

    private int totalPurchaseAmount() {
        int totalTickts = 0;

        for (int tickets : lottoResult.values()) {
            totalTickts += tickets;
        }

        return totalTickts * UNIT_OF_AMOUNT;
    }

    private int totalPrize() {
        int totalPrize = 0;

        for (LottoHandler lottoHandler : LottoHandler.values()) {
            if (lottoHandler == LottoHandler.OTHER) {
                continue;
            }

            totalPrize += lottoHandler.getPrize() * lottoResult.getOrDefault(lottoHandler, 0);
        }

        return totalPrize;
    }
}
