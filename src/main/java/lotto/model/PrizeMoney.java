package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class PrizeMoney {
    private final Map<Integer, Integer> prizeMoney;

    public PrizeMoney() {
        this.prizeMoney = new HashMap<>();
        this.prizeMoney.put(3, 5000);
        this.prizeMoney.put(4, 50000);
        this.prizeMoney.put(5, 1500000);
        this.prizeMoney.put(6, 2000000000);
    }

    public int getPrizeMoney(int matchCount) {
        return this.prizeMoney.getOrDefault(matchCount, 0);
    }

    public int getBonusPrizeMoney(int matchCount, boolean isMatchBonus) {
        if (matchCount == 5 && isMatchBonus) {
            return 1500000;
        }
        return 0;
    }
}
