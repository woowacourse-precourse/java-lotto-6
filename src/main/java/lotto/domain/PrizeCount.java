package lotto.domain;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class PrizeCount {
    private final Map<Prize, Integer> prizeCount;

    public PrizeCount(List<Prize> matchResult) {
        this.prizeCount = new LinkedHashMap<>();
        List<Prize> prizes = Stream.of(Prize.values())
                .filter(prize -> !prize.equals(Prize.NONE))
                .sorted(Comparator.reverseOrder())
                .toList();

        prizes.forEach(prize -> prizeCount.put(prize, 0));
        setPrizeCount(matchResult);
    }

    private void setPrizeCount(List<Prize> matchResult) {
        for (Prize prize : matchResult) {
            if (prize.equals(Prize.NONE)) {
                continue;
            }
            prizeCount.put(prize, prizeCount.get(prize) + 1);
        }
    }

    public double calculateReturnRate(Money money) {
        return money.calculateReturnRate(getTotalWinningAmount());
    }

    public Map<Prize, Integer> getPrizeCount() {
        return Collections.unmodifiableMap(this.prizeCount);
    }

    private long getTotalWinningAmount() {
        return prizeCount.keySet().stream()
                .mapToLong(prize -> prize.calculateAmount(prizeCount.get(prize)))
                .sum();
    }
}