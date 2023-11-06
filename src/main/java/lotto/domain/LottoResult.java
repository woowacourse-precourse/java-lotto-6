package lotto.domain;

import lotto.constant.LottoRank;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class LottoResult {
    private final Map<LottoRank, Integer> result = new HashMap<>();

    public LottoResult() {
        Stream.of(LottoRank.values()).forEach(lottoRank -> result.put(lottoRank, 0));
    }

    public void increaseLottoRankCount(LottoRank lottoRank) {
        int currentCount = result.get(lottoRank);
        result.replace(lottoRank, currentCount + 1);
    }

    public Map<LottoRank, Integer> getResult() {
        HashMap<LottoRank, Integer> copiedResult = new HashMap<>(result);
        copiedResult.remove(LottoRank.OUT_RANK);
        return copiedResult;
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
