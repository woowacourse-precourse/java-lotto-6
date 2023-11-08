package lotto.model;

import static lotto.utils.Constants.DECIMAL_POINT;
import static lotto.utils.Constants.HUNDRED_RATE;
import static lotto.utils.Constants.LOTTO_PRICE;

import java.util.List;
import java.util.Map;

public class WiningTypeCount {

    private final Map<WiningType, Integer> winingCountMap;

    public WiningTypeCount(final Map<WiningType, Integer> winingCountMap) {
        this.winingCountMap = winingCountMap;
    }

    public double calculateRateOfReturn(List<Lotto> lottos) {
        long amount = sumAmount();
        double money = lottos.size() * LOTTO_PRICE;
        double rateOfReturn = Math.round((amount / money) * DECIMAL_POINT) / DECIMAL_POINT * HUNDRED_RATE;
        return rateOfReturn;
    }

    private long sumAmount() {
        long totAmount = 0;
        for (WiningType winingType : winingCountMap.keySet()) {
            totAmount += winingCountMap.getOrDefault(winingType, 0) * winingType.getAmount();
        }
        return totAmount;
    }

    public int getWiningCount(WiningType winingType) {
        return winingCountMap.get(winingType);
    }
}
