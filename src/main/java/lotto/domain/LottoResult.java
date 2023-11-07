package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.LottoResultStatus;

public class LottoResult {
    private Map<LottoResultStatus, Integer> result;

    public LottoResult() {
        result = new HashMap<>() {{
            put(LottoResultStatus.NOTHING, 0);
            put(LottoResultStatus.THREE, 0);
            put(LottoResultStatus.FOUR, 0);
            put(LottoResultStatus.FIVE, 0);
            put(LottoResultStatus.FIVE_BONUS, 0);
            put(LottoResultStatus.SIX, 0);
        }};
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
        return 100.0 * calculateEarnPrice() / price;
    }

    private long calculateEarnPrice() {
        return result.entrySet().stream()
                .mapToLong(entry -> (entry.getKey().getWinnings() * entry.getValue()))
                .sum();
    }
}
