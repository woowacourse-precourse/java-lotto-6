package lotto.lotto;

import static lotto.lotto.LottoResult.FIFTH_PRIZE;
import static lotto.lotto.LottoResult.FIRST_PRIZE;
import static lotto.lotto.LottoResult.FOURTH_PRIZE;
import static lotto.lotto.LottoResult.SECOND_PRIZE;
import static lotto.lotto.LottoResult.THIRD_PRIZE;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

final class LottoStatus {
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("당첨 통계\n---\n");
        stringBuilder.append(lottoResultToStautsString(FIFTH_PRIZE));
        stringBuilder.append(lottoResultToStautsString(FOURTH_PRIZE));
        stringBuilder.append(lottoResultToStautsString(THIRD_PRIZE));
        stringBuilder.append(lottoResultToStautsString(SECOND_PRIZE));
        stringBuilder.append(lottoResultToStautsString(FIRST_PRIZE));
        stringBuilder.append(returnRateString());
        return stringBuilder.toString();
    }

    private String lottoResultToStautsString(LottoResult lottoResult) {
        return String.format("%s - %d개\n", lottoResult, resultToCount.getOrDefault(lottoResult, 0));
    }

    private String returnRateString() {
        return String.format("총 수익률은 %.1f%%입니다.", calculateReturnRate());
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