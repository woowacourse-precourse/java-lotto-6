package lotto.model;

import java.util.Map;
import lotto.Domain.LottoRate;

public class RateCal {
    private int sumPrize = 0;
    private double returnRate;
    private Map<Integer, Integer> prizeCount;

    public RateCal(Map<Integer, Integer> prizeCount) {
        this.prizeCount = prizeCount;
        setSumPrize();
    }

    public void setSumPrize() {
        LottoRate values[] = LottoRate.values();
        for (Integer key : prizeCount.keySet()) {

            sumPrize = sumPrize + findLottoPrize(values, key) * prizeCount.get(key);

        }
    }

    public int findLottoPrize(LottoRate[] values, Integer key) {
        for (LottoRate obj :
                values) {
            if (key == obj.getRank()) {
                return obj.getMoney();
            }
        }
        return 0;
    }

    public double getReturnRate(int price) {
        returnRate = price / (double) sumPrize;
        return returnRate;
    }
}
