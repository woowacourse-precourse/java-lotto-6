package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LottoResult {
    private final Map<rank, Integer> result = new LinkedHashMap<>();

    public LottoResult() {
        Stream.of(rank.values()).forEach(rank -> result.put(rank, 0));
    }

    public void increaseLottoRankCount(rank rank) {
        int currentCount = result.get(rank);
        result.replace(rank, currentCount + 1);
    }

    public Map<rank, Integer> getResult() {
        return new LinkedHashMap<>(result);
    }

    public double calculateProfitRate(Payment payment) {
        long totalPrizeMoney = calculateTotalPrizeMoney();
        return (double) totalPrizeMoney / payment.getAmount() * 100;
    }

    private long calculateTotalPrizeMoney() {
        long totalPrizeMoney = 0;

        for (rank rank : result.keySet()) {
            int count = result.get(rank);
            totalPrizeMoney += (long) rank.getPrizeMoney() * count;
        }
        return totalPrizeMoney;
    }
}