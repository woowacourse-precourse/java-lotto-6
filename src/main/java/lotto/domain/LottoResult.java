package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LottoResult {
    private final Map<Rank, Integer> result = new LinkedHashMap<>();

    public LottoResult() {
        Stream.of(Rank.values()).forEach(rank -> result.put(rank, 0));
    }

    public void increaseLottoRankCount(Rank rank) {
        int currentCount = result.get(rank);
        result.replace(rank, currentCount + 1);
    }

    public Map<Rank, Integer> getResult() {
        return new LinkedHashMap<>(result);
    }

    public double calculateProfitRate(Payment payment) {
        long totalPrizeMoney = calculateTotalPrizeMoney();
        return (double) totalPrizeMoney / payment.getAmount() * 100;
    }

    private long calculateTotalPrizeMoney() {
        long totalPrizeMoney = 0;

        for (Rank rank : result.keySet()) {
            int count = result.get(rank);
            totalPrizeMoney += (long) rank.getPrizeMoney() * count;
        }
        return totalPrizeMoney;
    }
}