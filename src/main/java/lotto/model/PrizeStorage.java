package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PrizeStorage {
    private Map<Prize, Integer> prizeCount = new EnumMap<>(Prize.class);

    public PrizeStorage(List<Prize> prizes) {
        for (Prize prize : prizes) {
            addPrize(prize);
        }
    }

    private void addPrize(Prize prize) {
        prizeCount.put(prize, prizeCount.getOrDefault(prize, 0) + 1);
    }

    public List<Integer> getPrizeCount() {
        List<Integer> count = new ArrayList<>();
        for (Prize prize : Prize.values()) {
            count.add(prizeCount.getOrDefault(prize, 0));
        }
        return count;
    }
}