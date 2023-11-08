package Model;

import java.util.EnumMap;
import java.util.Map;

public class PrizeResult {
    private Map<Prize, Integer> prizes;

    public PrizeResult() {
        prizes = new EnumMap<Prize, Integer>(Prize.class);
        for (Prize prize : Prize.values()) {
            prizes.put(prize, 0);
        }
    }

    public void addPrize(final Prize prize) {
        prizes.put(prize, prizes.get(prize) + 1);
    }
    
}
