package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningStatus {
    private Map<PrizeType, Integer> prizeTypeWithCount;

    public WinningStatus() {
        init();
    }

    private void init() {
        this.prizeTypeWithCount = new HashMap<>();

        for (PrizeType prizeType : PrizeType.values()) {
            prizeTypeWithCount.put(prizeType, 0);
        }
    }

    public void add(PrizeType prizeType) {
        prizeTypeWithCount.put(prizeType, prizeTypeWithCount.get(prizeType) + 1);
    }

    public double getPrizeMoney() {
        double prizeMoney = 0;
        for (PrizeType prizeType : prizeTypeWithCount.keySet()) {
            prizeMoney += getPrizeMoney(prizeType);
        }

        return prizeMoney;
    }

    public double getPrizeMoney(PrizeType prizeType) {
        return (double) prizeTypeWithCount.get(prizeType) * prizeType.getPrize();
    }

    public int getCount(PrizeType prizeType) {
        return prizeTypeWithCount.get(prizeType);
    }

    public String getMessages() {
        StringBuilder buffer = new StringBuilder();
        buffer.append(PrizeType.getMessage(PrizeType.MATCH3, getCount(PrizeType.MATCH3)));
        buffer.append(PrizeType.getMessage(PrizeType.MATCH4, getCount(PrizeType.MATCH4)));
        buffer.append(PrizeType.getMessage(PrizeType.MATCH5, getCount(PrizeType.MATCH5)));
        buffer.append(PrizeType.getMessage(PrizeType.MATCH5_WITH_BONUS, getCount(PrizeType.MATCH5_WITH_BONUS)));
        buffer.append(PrizeType.getMessage(PrizeType.MATCH6, getCount(PrizeType.MATCH6)));

        return buffer.toString();
    }
}
