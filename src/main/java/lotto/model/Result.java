package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {

    Map<Winning, Integer> result = new EnumMap<Winning, Integer>(Winning.class);

    public Result() {
        for (Winning winning : Winning.values()) {
            result.put(winning, 0);
        }
    }

    public void put(List<Winning> winnings) {
        for (Winning winning : winnings) {
            result.put(winning, result.get(winning) + 1);
        }
    }

    public long calculatePrizeMoney() {
        return result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getAmount() * entry.getValue())
                .sum();
    }

    public Map<Winning, Integer> getResult() {
        return result;
    }
}
