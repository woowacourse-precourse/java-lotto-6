package lotto.domain.lottoResult;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.lotto.PurchaseLottos;
import lotto.domain.lotto.PurchasePrice;
import lotto.domain.lottoWinning.LottoWinning;

public class LottoResult {
    private static final int INIT_COUNT = 0;
    private static final double PERCENT = 100.0;
    private final Map<LottoResultStatus, Integer> result;

    private LottoResult() {
        result = new HashMap<>() {{
            put(LottoResultStatus.NOTHING, INIT_COUNT);
            put(LottoResultStatus.THREE, INIT_COUNT);
            put(LottoResultStatus.FOUR, INIT_COUNT);
            put(LottoResultStatus.FIVE, INIT_COUNT);
            put(LottoResultStatus.FIVE_BONUS, INIT_COUNT);
            put(LottoResultStatus.SIX, INIT_COUNT);
        }};
    }

    public static LottoResult of(PurchaseLottos purchaseLottos, LottoWinning lottoWinning) {
        LottoResult lottoResult = new LottoResult();
        purchaseLottos.getPurchaseLottos().forEach(lotto -> {
            LottoResultStatus lottoResultStatus = lottoWinning.calculateLottoResultStatus(lotto);
            lottoResult.add(lottoResultStatus);
        });
        return lottoResult;
    }

    public void add(LottoResultStatus resultStatus) {
        result.put(resultStatus, result.get(resultStatus) + 1);
    }

    public int get(LottoResultStatus resultStatus) {
        return result.get(resultStatus);
    }

    public String roundRateOfReturn(PurchasePrice purchasePrice) {
        double rateOfReturn = calculateRateOfReturn(purchasePrice);
        return String.format("%,.1f", rateOfReturn);
    }

    private double calculateRateOfReturn(PurchasePrice purchasePrice) {
        int price = purchasePrice.getPrice();
        return PERCENT * calculateEarnPrice() / price;
    }

    private long calculateEarnPrice() {
        return result.entrySet().stream()
                .mapToLong(entry -> (entry.getKey().getWinnings() * entry.getValue()))
                .sum();
    }
}
