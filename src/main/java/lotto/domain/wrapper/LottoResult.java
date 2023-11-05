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

    private int totalPurchaseAmount() {
        int totalTickts = 0;

        for (int tickets : lottoResult.values()) {
            totalTickts += tickets;
        }

        return totalTickts * UNIT_OF_AMOUNT;
    }
}
