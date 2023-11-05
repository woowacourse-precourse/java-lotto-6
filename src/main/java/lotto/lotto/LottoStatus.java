package lotto.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class LottoStatus {
    private final Map<LottoResult, Integer> resultToCount;
    private final long buyMoney;

    LottoStatus(int buyMoney) {
        this.resultToCount = new HashMap<>();
        this.buyMoney = buyMoney;
    }

    LottoStatus insert(LottoResult lottoResult) {
        resultToCount.put(lottoResult, resultToCount.getOrDefault(lottoResult, 0) + 1);
        return this;
    }

    private double calculateReturnRate() {
        double totalPrizeMoney = (double) calculatePrizeMoney();
        return totalPrizeMoney * 100 / (double) buyMoney;
    }

    private long calculatePrizeMoney() {
        return resultToCount.keySet().stream()
                .map(lottoResult -> {
                    long count = resultToCount.get(lottoResult);
                    return count * lottoResult.getPrice();
                })
                .mapToLong(value -> value)
                .sum();
    }

    boolean isLogicallyEqual(Map<LottoResult, Integer> expected) {
        Set<LottoResult> expectedKeys = expected.keySet();
        Set<LottoResult> realKeys = resultToCount.keySet();
        if (!realKeys.equals(expectedKeys)) {
            return false;
        }
        int differentElementsCount = (int) expectedKeys.stream()
                .filter(lottoResult -> !Objects.equals(expected.get(lottoResult), resultToCount.get(lottoResult)))
                .count();
        return differentElementsCount == 0;
    }

    boolean isReturnRateEqualsTo(double expected) {
        return Objects.equals(String.format("%.1f", calculateReturnRate()), String.format("%.1f", expected));
    }
}