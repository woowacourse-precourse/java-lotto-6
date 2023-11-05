package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningStatus {
    private Map<PrizeType, Integer> prizeTypeWithCount;

    public WinningStatus() {
        this.prizeTypeWithCount = new HashMap<>();

        for (PrizeType prizeType : PrizeType.values()) {
            prizeTypeWithCount.put(prizeType, 0);
        }
    }

    public void add(PrizeType prizeType) {
        if (prizeType != PrizeType.NOT_APPLICABLE) {
            prizeTypeWithCount.put(prizeType, prizeTypeWithCount.get(prizeType) + 1);
        }
    }

    public double getSum() {
        double returnMoney = 0;
        for (PrizeType prizeType : prizeTypeWithCount.keySet()) {
            returnMoney += getSum(prizeType);
        }

        return returnMoney;
    }

    public double getSum(PrizeType prizeType) {
        return (double)prizeTypeWithCount.get(prizeType) * prizeType.getPrize();
    }
}
