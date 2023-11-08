package Model;

import java.util.EnumMap;
import java.util.Map;

public class PrizeResult {
    private Map<Prize, Integer> prizes;
    private int totalSum;

    public PrizeResult() {
        prizes = new EnumMap<Prize, Integer>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizes.put(prize, 0);
        }
        totalSum = 0;
    }

    public void addPrize(final Prize prize) {
        prizes.put(prize, prizes.get(prize) + 1);
        totalSum += prize.getMoney();
    }

    public int getPrize(final Prize prize) {
        return prizes.get(prize);
    }

    public int getTotalSum() {
        return totalSum;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
