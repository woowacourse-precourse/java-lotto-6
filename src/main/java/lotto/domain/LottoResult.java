package lotto.domain;

import lotto.constant.LottoRank;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LottoResult {
    private final Map<LottoRank, Integer> result = new LinkedHashMap<>();

    public LottoResult() {
        Stream.of(LottoRank.values()).forEach(lottoRank -> result.put(lottoRank, 0));
    }

    public void increaseLottoRankCount(LottoRank lottoRank) {
        int currentCount = result.get(lottoRank);
        result.replace(lottoRank, currentCount + 1);
    }

    public Map<LottoRank, Integer> getResult() {
        return new LinkedHashMap<>(result);
    }

    public double calculateProfitRate(Payment payment) {
        long totalPrizeMoney = calculateTotalPrizeMoney();
        return (double) totalPrizeMoney / payment.getAmount();
    }

    private long calculateTotalPrizeMoney() {
        long totalPrizeMoney = 0;

        for (LottoRank lottoRank : result.keySet()) {
            int count = result.get(lottoRank);
            totalPrizeMoney += (long) lottoRank.getPrizeMoney() * count;
        }
        return totalPrizeMoney;
    }
}
