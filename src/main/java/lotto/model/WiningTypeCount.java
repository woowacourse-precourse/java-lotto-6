package lotto.model;

import java.util.List;
import java.util.Map;

public class WiningTypeCount {

    private static final double LOTTO_PRICE = 1000.0;
    private static final double DECIMAL_POINT = 1000.0;
    private static final double HUNDRED_RATE = 100.0;

    private Map<WiningType, Integer> winingCountMap;

    public WiningTypeCount(Map<WiningType, Integer> winingCountMap) {
        this.winingCountMap = winingCountMap;
    }

    public double calculateRateOfReturn(List<Lotto> lottos) {
        long amount = sumAmount();
        return Math.round((amount / (lottos.size() * LOTTO_PRICE)) * DECIMAL_POINT) / DECIMAL_POINT * HUNDRED_RATE;
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
